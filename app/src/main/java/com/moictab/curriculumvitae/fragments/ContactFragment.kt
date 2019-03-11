package com.moictab.curriculumvitae.fragments

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast

import com.moictab.curriculumvitae.R

import butterknife.BindView
import butterknife.ButterKnife

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ContactFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactFragment : Fragment() {

    @BindView(R.id.button_email)
    internal var buttonEmail: ImageButton? = null

    @BindView(R.id.button_linkedin)
    internal var buttonLinkedin: ImageButton? = null

    @BindView(R.id.button_phone)
    internal var buttonPhone: ImageButton? = null

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_contact, container, false)
        ButterKnife.bind(this, view)
        activity.title = getString(R.string.contact_fragment_title)

        buttonEmail!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("xxx@gmail.com"))

            try {
                startActivity(Intent.createChooser(intent, "Send email..."))
            } catch (ex: android.content.ActivityNotFoundException) {
                Toast.makeText(activity, R.string.no_email_clients_installed, Toast.LENGTH_SHORT).show()
            }
        }

        buttonLinkedin!!.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://moictab"))
            val packageManager = context.packageManager
            val list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
            if (list.isEmpty()) {
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=moictab"))
            }

            startActivity(intent)
        }

        buttonPhone!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "XXXXXXXXX", null))
            startActivity(intent)
        }

        // Inflate the layout for this fragment
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContactFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): ContactFragment {
            val fragment = ContactFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
