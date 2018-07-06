package br.com.hugo.rachacontakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var ProgressStatus: Int = 10

    fun print(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBarId.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                ProgressStatus = i
                txtSeekBarId.text = "${ProgressStatus.toString()}%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) { }
            override fun onStopTrackingTouch(seekBar: SeekBar)  { }
        })
    }

    private fun validaCampo(x:String?) : Boolean = !(x==null || x.equals(""))

    fun calcularConta(){

        if(validaCampo(edtValorId.text.toString()) &&
                validaCampo(edtNumPessoasId.text.toString())) {

            val valor = edtValorId.text.toString().toDouble()
            val pessoas = edtNumPessoasId.text.toString().toInt()

            val ValorGarcom = valor / 100.0 * ProgressStatus
            val ValorTotal = valor + ValorGarcom
            val ValorIndividual = ValorTotal / pessoas

            vlrGarcomId.text = "RS${String.format("%02.2f",ValorGarcom)}"
            vlrTotalId.text = "RS${String.format("%02.2f",ValorTotal)}"
            vlrIndividualId.text = "RS${String.format("%02.2f",ValorIndividual)}"

        }else{
            print("Preencha os valores");
        }
    }
}
