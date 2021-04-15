package com.example.lv2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.lv2.databinding.FragmentEditPersonBinding
import com.example.lv2.model.Person

class EditPersonFragment : Fragment() {
    lateinit var fragmentEditPersonBinding: FragmentEditPersonBinding

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

        arguments?.let {
            val person = it.getSerializable(KEY_PERSON) as Person
            fragmentEditPersonBinding.etEditPersonName.setText(person.name)
            fragmentEditPersonBinding.etEditPersonBDay.setText(person.dateOfBirth)
            fragmentEditPersonBinding.etEditPersonQuote.setText(person.quote)
            fragmentEditPersonBinding.etEditPersonDescription.setText(person.description)
            fragmentEditPersonBinding.etEditPersonImageLink.setText(person.imageLink)
            Glide.with(this)
                .load(person.imageLink)
                .into(fragmentEditPersonBinding.ivEditPersonProfile)
        }

        return fragmentEditPersonBinding.root
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
    }
}