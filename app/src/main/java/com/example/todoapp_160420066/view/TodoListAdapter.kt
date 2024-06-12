package com.example.todoapp_160420066.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp_160420066.databinding.TodoItemLayoutBinding
import com.example.todoapp_160420066.model.Todo

class TodoListAdapter(val todoList:ArrayList<Todo>, val adapterOnClick : (Todo) -> Unit)
    : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>(), TodoCheckedChangeListener,TodoEditClick{
    class TodoViewHolder(var binding:TodoItemLayoutBinding):
        RecyclerView.ViewHolder(binding.root)
    override fun onCheckedChanged(cb: CompoundButton,
                                  isChecked: Boolean, obj: Todo) {
        if(cb.isPressed) {
            adapterOnClick(obj)
        }
    }
    override fun onTodoEditClick(v: View) {
        val uuid = v.tag.toString().toInt()
        val action = TodoListFragmentDirections.actionEditTodo(uuid)

        Navigation.findNavController(v).navigate(action)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var view = TodoItemLayoutBinding.inflate(inflater, parent, false)

        return TodoViewHolder(view)

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int)
    {
        holder.binding.todo = todoList[position]
        holder.binding.listener = this
        holder.binding.editListener = this
    /*
        holder.binding.checkTask.text = todoList[position].title
        holder.binding.imgEdit.setOnClickListener {
            val action =
                TodoListFragmentDirections.actionEditTodo(todoList[position].uuid)

            Navigation.findNavController(it).navigate(action)
        }*/
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
    fun updateTodoList(newTodoList: List<Todo>) {
        todoList.clear()
        todoList.addAll(newTodoList)
        notifyDataSetChanged()
    }


}
