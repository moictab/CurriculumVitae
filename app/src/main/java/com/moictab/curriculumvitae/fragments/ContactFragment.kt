package com.moictab.curriculumvitae.fragments

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import com.moictab.curriculumvitae.R

class ContactFragment : Fragment() {
  private var onFragmentInteractionListener: OnFragmentInteractionListener? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_contact, container, false)
    activity?.title ?: getString(R.string.contact_fragment_title)

    val btnEmail = view.findViewById<ImageButton>(R.id.btn_email)
    btnEmail.setOnClickListener {
      val intent = Intent(Intent.ACTION_SEND)
      intent.type = "message/rfc822"
      intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("xxx@gmail.com"))
      try {
        startActivity(Intent.createChooser(intent, "Send email..."))
      } catch (e: android.content.ActivityNotFoundException) {
        Log.e(TAG, "Error getting activity for sending emails", e)
        Toast.makeText(activity, R.string.no_email_clients_installed, Toast.LENGTH_SHORT).show()
      }
    }

    val btnLinkedIn = view.findViewById<ImageButton>(R.id.btn_linkedin)
    btnLinkedIn.setOnClickListener {
      var intent = Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://moictab"))
      val packageManager = context!!.packageManager
      val list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
      if (list.isEmpty()) {
        intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=moictab"))
      }
      startActivity(intent)
    }

    val btnPhone = view.findViewById<ImageButton>(R.id.btn_phone)
    btnPhone!!.setOnClickListener {
      val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "XXXXXXXXX", null))
      startActivity(intent)
    }

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

  companion object {
    const val TAG = "ContactFragment"

    fun newInstance(): ContactFragment {
      return ContactFragment()
    }
  }
}
