package com.example.mugfinal

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FrgmRenkler.newInstance] factory method to
 * create an instance of this fragment.
 */
class renkfragment : Fragment() {
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

    val secenek = arrayOf("Burgonya","Elektrik çivit rengi", "Rosy Brown","İlkbahar yeşili","Lavanta pembesi")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val sonuc = inflater.inflate(R.layout.fragment_renkfragment, container, false)
        val spinner = sonuc.findViewById<Spinner>(R.id.fragspin)
        val spinner2 = sonuc.findViewById<Spinner>(R.id.yazirenkspin)
        val spinner3 = sonuc.findViewById<Spinner>(R.id.yaziarkaplanspin)

        spinner?.adapter = ArrayAdapter(this.requireActivity(), R.layout.support_simple_spinner_dropdown_item, secenek) as SpinnerAdapter
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("Lütfen bir renk seçiniz.")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                if (id.toInt()==0){
                    sonuc.setBackgroundColor(Color.rgb(128,	0,	32	));
                }else if (id.toInt()==1){
                    sonuc.setBackgroundColor(Color.rgb(102,	0,	255));
                }else if (id.toInt()==2){
                    sonuc.setBackgroundColor(Color.rgb(205, 155, 155));
                }else if (id.toInt()==3){
                    sonuc.setBackgroundColor(Color.rgb(0,	255,	127));
                }else if(id.toInt()==4){
                    sonuc.setBackgroundColor(Color.rgb(251,	174,	210	));
                }
            }
        }
        return sonuc
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FrgmRenkler.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            renkfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}