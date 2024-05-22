package com.example.todoapp_160420066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp_160420066.R
import com.example.todoapp_160420066.databinding.FragmentCreateTodoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditTodoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditTodoFragment : Fragment() {
    private lateinit var binding: FragmentCreateTodoBinding
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateTodoBinding.inflate(inflater,container,
            false)
        return binding.root
    }
}