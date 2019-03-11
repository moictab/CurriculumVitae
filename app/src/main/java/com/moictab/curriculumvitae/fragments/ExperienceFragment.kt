package com.moictab.curriculumvitae.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.moictab.curriculumvitae.R
import com.moictab.curriculumvitae.adapters.ExperiencesAdapter
import com.moictab.curriculumvitae.controller.ExperienceController

class ExperienceFragment : Fragment() {
  private var adapter: RecyclerView.Adapter<*>? = null
  private var layoutManager: RecyclerView.LayoutManager? = null
  private var onFragmentInteractionListener: OnFragmentInteractionListener? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    activity!!.title = getString(R.string.experience_fragment_title)
    val experiences = ExperienceController().getExperiencesFromAssets(activity!!)
    val view = inflater.inflate(R.layout.fragment_experience, container, false)
    val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
    recyclerView.setHasFixedSize(true)
    layoutManager = LinearLayoutManager(activity)
    recyclerView.layoutManager = layoutManager
    adapter = ExperiencesAdapter(experiences!!, activity!!)
    recyclerView.adapter = adapter
    return view
  }

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is OnFragmentInteractionListener) {
      onFragmentInteractionListener = context
    } else {
      throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
    }
  }

  override fun onDetach() {
    super.onDetach()
    onFragmentInteractionListener = null
  }

  interface OnFragmentInteractionListener {
    fun onFragmentInteraction(uri: Uri)
  }
}
