package me.dio.vinicius.repolistingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import me.dio.vinicius.repolistingapp.R
import me.dio.vinicius.repolistingapp.core.createDialog
import me.dio.vinicius.repolistingapp.core.createProgressDialog
import me.dio.vinicius.repolistingapp.core.hideSoftKeyboard
import me.dio.vinicius.repolistingapp.data.repositories.RepoRepository
import me.dio.vinicius.repolistingapp.databinding.ActivityMainBinding
import me.dio.vinicius.repolistingapp.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val dialog by lazy { createProgressDialog()}
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { RepoListAdapter()}
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.rvRepoList.adapter = adapter

        viewModel.getRepoList("ViniciusJMR")
        viewModel.repos.observe(this) {
            when(it){
                is MainViewModel.State.Error -> {
                    createDialog {
                        setMessage(it.error.message)
                    }.show()
                    dialog.dismiss()
                }
                MainViewModel.State.Loading -> dialog.show()
                is MainViewModel.State.Success -> {
                    dialog.dismiss()
                    adapter.submitList(it.list)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchView = (menu.findItem(R.id.action_search).actionView as SearchView)
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {viewModel.getRepoList(it)}
        binding.root.hideSoftKeyboard()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.i(TAG, "onQueryTextChanged: $newText")
        return false
    }

    companion object {
        private const val TAG = "TAG"
    }
}