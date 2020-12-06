package com.aakash.game


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random


var counter:Int=0;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start: Button =findViewById(R.id.start1)
        val firstnum: Button =findViewById(R.id.Firstnum)
        val secondnum: Button =findViewById(R.id.Secondnum)
        val result1:TextView=findViewById(R.id.result1)
        val result2:TextView=findViewById(R.id.result2)
        var correct:Int=0;
        var incorrect:Int=0;
        val playagian:Button=findViewById(R.id.Playagain)
        start.setOnClickListener(){


            start.visibility= View.INVISIBLE;
            firstnum.visibility= View.VISIBLE;
            secondnum.visibility= View.VISIBLE
            val a:Int=Random.nextInt(0, 100);
            val b:Int=Random.nextInt(0, 100);

            if(a!=b){
                firstnum.text=a.toString()
                secondnum.text=b.toString()
                firstnum.setOnClickListener(){

                    counter=counter+1;
                    if(a>b){
                        correct++
                    }
                    else{
                        incorrect++
                    }

                    val c:Int=Random.nextInt(0, 100);
                    val d:Int=Random.nextInt(0, 100);

                    if(c!=d){
                        firstnum.text=c.toString()
                        secondnum.text=d.toString()}

                    else{
                        Toast.makeText(this,"The result is hey", Toast.LENGTH_LONG).show()
                    }

                    if(counter==10){
                        Toast.makeText(this,"Result is $counter ", Toast.LENGTH_LONG).show()
                        result1.visibility=View.VISIBLE;
                        result2.visibility=View.VISIBLE;
                        playagian.visibility=View.VISIBLE;
                        result1.text="Correct: $correct"
                        result2.text="Incorrect: $incorrect"
                        firstnum.text=""
                        secondnum.text=""
                        firstnum.isEnabled=false;
                        secondnum.isEnabled=false;
                        playagian.setOnClickListener(){
                            setContentView(R.layout.activity_main)
                        }
                    }
                }

                secondnum.setOnClickListener(){
                    counter=counter+1;
                    if(a>b){
                        incorrect++
                    }
                    else{
                        correct++
                    }

                    val e:Int=Random.nextInt(0, 100);
                    val f:Int=Random.nextInt(0, 100);
                    if(e!=f){
                        firstnum.text=e.toString()
                        secondnum.text=f.toString()}
                    else{
                        Toast.makeText(this,"Show again", Toast.LENGTH_LONG).show()
                    }
                    if(counter==10){
                        Toast.makeText(this,"The count is $counter ", Toast.LENGTH_LONG).show()
                        result1.visibility=View.VISIBLE;
                        result2.visibility=View.VISIBLE;
                        playagian.visibility=View.VISIBLE;
                        result1.text="It is correct: $correct"
                        result2.text="It is incorrect: $incorrect"
                        firstnum.isEnabled=false;
                        secondnum.isEnabled=false;
                        playagian.setOnClickListener(){
                            setContentView(R.layout.activity_main)
                        }
                    }
                }

            }

        }
    }
}
