package com.example.todoapp_160420066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.todoapp_160420066.R
import com.example.todoapp_160420066.databinding.FragmentCreateTodoBinding
import com.example.todoapp_160420066.model.Todo
import com.example.todoapp_160420066.viewmodel.DetailTodoViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateTodoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateTodoFragment : Fragment() {
    private lateinit var viewModel: DetailTodoViewModel
    private lateinit var binding: FragmentCreateTodoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateTodoBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(DetailTodoViewModel::class.java)

        binding.btnAdd.setOnClickListener {
            var radio =
                view.findViewById<RadioButton>(binding.radioGroupPriority.checkedRadioButtonId)

            var todo = Todo(binding.txtTitle.text.toString(),
                binding.txtNotes.text.toString(), radio.tag.toString().toInt())

            val list = listOf(todo)
            viewModel.addTodo(list)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }


    }


}