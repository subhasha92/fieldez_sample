package com.example.fieldezapp.screens.userlist.view.fragment

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fieldezapp.R
import com.example.fieldezapp.screens.userlist.adapter.UserListAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class UserListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvView)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = UserListAdapter() { name ->

                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Alert")
                builder.setMessage("You customer name is $name")
                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    Toast.makeText(
                        requireContext(),
                        name, Toast.LENGTH_SHORT
                    ).show()
                }

                builder.show()

            }
        }

        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}