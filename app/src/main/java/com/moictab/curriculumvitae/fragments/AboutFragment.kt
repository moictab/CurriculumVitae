package com.moictab.curriculumvitae.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.moictab.curriculumvitae.R

class AboutFragment : Fragment() {
  private var onFragmentInteractionListener: OnFragmentInteractionListener? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_about, container, false)
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
