package com.moictab.curriculumvitae.fragments

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import com.moictab.curriculumvitae.R
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment() {
  private var mListener: OnFragmentInteractionListener? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_contact, container, false)
    ButterKnife.bind(this, view)
    activity?.title ?: getString(R.string.contact_fragment_title)

    btn_email.setOnClickListener {
      val intent = Intent(Intent.ACTION_SEND)
      intent.type = "message/rfc822"
      intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("xxx@gmail.com"))
      try {
        startActivity(Intent.createChooser(intent, "Send email..."))
      } catch (ex: android.content.ActivityNotFoundException) {
        Toast.makeText(activity, R.string.no_email_clients_installed, Toast.LENGTH_SHORT).show()
      }
    }

    btn_linkedin.setOnClickListener {
      var intent = Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://moictab"))
      val packageManager = context!!.packageManager
      val list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
      if (list.isEmpty()) {
        intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=moictab"))
      }

      startActivity(intent)
    }

    btn_phone!!.setOnClickListener {
      val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "XXXXXXXXX", null))
      startActivity(intent)
    }

    return view
  }

  // TODO: Rename method, update argument and hook method into UI event
  fun onButtonPressed(uri: Uri) {
    if (mListener != null) {
      mListener!!.onFragmentInteraction(uri)
    }
  }

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is OnFragmentInteractionListener) {
      mListener = context
    } else {
      throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
    }
  }

  override fun onDetach() {
    super.onDetach()
    mListener = null
  }


  interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    fun onFragmentInteraction(uri: Uri)
  }

  companion object {
    private val ARG_PARAM1 = "param1"
    private val ARG_PARAM2 = "param2"

    fun newInstance(param1: String, param2: String): ContactFragment {
      val fragment = ContactFragment()
      val args = Bundle()
      args.putString(ARG_PARAM1, param1)
      args.putString(ARG_PARAM2, param2)
      fragment.arguments = args
      return fragment
    }
  }
}
