package com.example.lv3task2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.lv3task2.data.PeopleRepository
import com.example.lv3task2.databinding.FragmentEditPersonBinding
import com.example.lv3task2.model.InspiringPerson

class EditPersonFragment : Fragment() {

    lateinit var fragmentEditPersonBinding: FragmentEditPersonBinding
    private lateinit var person: InspiringPerson

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
                person = it.getSerializable(KEY_PERSON) as InspiringPerson
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
        fragmentEditPersonBinding.btnEditSave.setOnClickListener { onClickSave() }
        fragmentEditPersonBinding.btnEditDelete.setOnClickListener { onClickDelete() }

        return fragmentEditPersonBinding.root
    }

    private fun onClickDelete() {
        if (arguments == null) {
            Toast.makeText(activity, "Nothing to delete, save a person first!", Toast.LENGTH_SHORT)
                .show()
            return
        }
        PeopleRepository.remove(person)
        this.activity?.supportFragmentManager?.popBackStack()
    }

    private fun onClickSave() {
        fragmentEditPersonBinding.apply {
            if (etEditPersonName.text.toString() == "" || etEditPersonBDay.text.toString() == "") {
                Toast.makeText(
                    activity,
                    "Add the persons name and date of birth.",
                    Toast.LENGTH_SHORT
                ).show()
                return
            }
        }
        val editedPerson = InspiringPerson(
            fragmentEditPersonBinding.etEditPersonName.text.toString(),
            fragmentEditPersonBinding.etEditPersonBDay.text.toString(),
            fragmentEditPersonBinding.etEditPersonDescription.text.toString(),
            fragmentEditPersonBinding.etEditPersonQuote.text.toString(),
            fragmentEditPersonBinding.etEditPersonImageLink.text.toString()
        )
        if (arguments == null) {
            PeopleRepository.insert(editedPerson)
        } else {
            PeopleRepository.edit(person, editedPerson)
        }

        this.activity?.supportFragmentManager?.popBackStack()
    }

    companion object {
        const val TAG = "Edit PERSON FRAGMENT"
        private const val KEY_PERSON = "PERSON"

        fun create(person: InspiringPerson?): EditPersonFragment {
            return if (person == null) {
                EditPersonFragment()
            } else {
                val args = Bundle()
                args.putSerializable(KEY_PERSON, person)
                val fragment = EditPersonFragment()
                fragment.arguments = args
                fragment
            }
        }
    }
}