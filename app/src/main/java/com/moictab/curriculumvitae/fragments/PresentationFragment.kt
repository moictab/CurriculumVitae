package com.moictab.curriculumvitae.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.moictab.curriculumvitae.R

class PresentationFragment : Fragment() {
  private var onFragmentInteractionListener: OnFragmentInteractionListener? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    activity!!.title = getString(R.string.presentation_fragment_title)
    val view = inflater.inflate(R.layout.fragment_presentation, container, false)
    val ivIcon = view.findViewById<ImageView>(R.id.iv_icon)
    ivIcon.setImageResource(R.mipmap.moidroid)
    val ivFont = view.findViewById<ImageView>(R.id.iv_name)
    ivFont.setImageResource(R.mipmap.moi_font)
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
