package com.example.martin.viewmodel_livedataex

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        val resultObserver= Observer<Float> {
                result -> resultText.text = result.toString() }
        viewModel.getResult().observe(this, resultObserver)

        convertButton.setOnClickListener {
            if (dollarText.text.isNotEmpty()) {
                viewModel.setAmount(dollarText.text.toString())

            } else {
                resultText.text = "No Value"
            }
        }
    }

}
