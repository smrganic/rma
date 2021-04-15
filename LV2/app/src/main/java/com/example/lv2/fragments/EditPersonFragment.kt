package com.example.lv2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.lv2.data.PeopleRepository
import com.example.lv2.databinding.FragmentEditPersonBinding
import com.example.lv2.model.Person

class EditPersonFragment : Fragment() {

    lateinit var fragmentEditPersonBinding: FragmentEditPersonBinding
    private val peopleRepository = PeopleRepository
    private lateinit var person: Person

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentEditPersonBinding = FragmentEditPersonBinding.inflate(
            inflater,
            container,
            false
        )
        if (arguments != null) {
            arguments!!.let {
                person = it.getSerializable(KEY_PERSON) as Person
                fragmentEditPersonBinding.etEditPersonName.setText(person.name)
                fragmentEditPersonBinding.etEditPersonBDay.setText(person.dateOfBirth)
                fragmentEditPersonBinding.etEditPersonQuote.setText(person.quote)
                fragmentEditPersonBinding.etEditPersonDescription.setText(person.description)
                fragmentEditPersonBinding.etEditPersonImageLink.setText(person.imageLink)
                Glide.with(this)
                    .load(person.imageLink)
                    .into(fragmentEditPersonBinding.ivEditPersonProfile)
            }
        }
        fragmentEditPersonBinding.btnEdit.setOnClickListener { onClick() }

        return fragmentEditPersonBinding.root
    }

    private fun onClick() {
        val editedPerson = Person(
            fragmentEditPersonBinding.etEditPersonName.text.toString(),
            fragmentEditPersonBinding.etEditPersonBDay.text.toString(),
            fragmentEditPersonBinding.etEditPersonDescription.text.toString(),
            fragmentEditPersonBinding.etEditPersonQuote.text.toString(),
            fragmentEditPersonBinding.etEditPersonImageLink.text.toString()
        )
        if (arguments == null) {
            peopleRepository.insertPerson(editedPerson)
        } else {
            peopleRepository.editPerson(person, editedPerson)
        }


        this.activity?.supportFragmentManager?.popBackStack()
    }

    companion object {
        const val TAG = "Edit PERSON FRAGMENT"
        private const val KEY_PERSON = "PERSON"

        fun create(person: Person): EditPersonFragment {
            val args = Bundle()
            args.putSerializable(KEY_PERSON, person)
            val fragment = EditPersonFragment()
            fragment.arguments = args
            return fragment
        }

        fun create(): EditPersonFragment {
            return EditPersonFragment()
        }
    }
}