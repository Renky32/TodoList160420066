package com.example.todoapp_160420066.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.todoapp_160420066.R
import com.example.todoapp_160420066.databinding.FragmentCreateTodoBinding
import com.example.todoapp_160420066.databinding.FragmentEditTodoBinding
import com.example.todoapp_160420066.model.Todo
import com.example.todoapp_160420066.viewmodel.DetailTodoViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditTodoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditTodoFragment : Fragment(), RadioClickListener, TodoSaveChangesClick
     {
    private lateinit var binding: FragmentEditTodoBinding
    private lateinit var viewModel: DetailTodoViewModel

    override fun onRadioClick(v: View, priority: Int, obj: Todo) {
        obj.priority = priority

    }




    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEditTodoBinding.inflate(inflater,container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailTodoViewModel::class.java)

        binding.txtJudulTodo.text = "Edit Todo"
        binding.btnSave.text = "Save Changes"
        binding.radioListener = this

        val uuid = EditTodoFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)
        observeViewModel()
        binding.radioListener = this
        binding.saveListener = this
/*
        binding.btnSave.setOnClickListener {
            val radio =
                view.findViewById<RadioButton>(binding.radioGroupPriority.checkedRadioButtonId)
            viewModel.update(binding.txtTitle.text.toString(),
                binding.txtNotes.text.toString(), radio.tag.toString().toInt(), uuid)
            Toast.makeText(view.context, "Todo updated", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }*/
    }
    fun observeViewModel() {
        viewModel.todoLD.observe(viewLifecycleOwner, Observer {
            binding.txtTitle.setText(it.title)
            binding.txtNotes.setText(it.notes)
            when (it.priority) {
                1 -> binding.radioLow.isChecked = true
                2 -> binding.radioMedium.isChecked = true
                else -> binding.radioHigh.isChecked = true
            }

        })

    }
         override fun onTodoSaveChangesClick(v: View, obj: Todo) {
             TODO("Not yet implemented")
             viewModel.update(obj.title, obj.notes, obj.priority, obj.uuid)
             Toast.makeText(v.context, "Todo Updated", Toast.LENGTH_SHORT).show()
         }


     }