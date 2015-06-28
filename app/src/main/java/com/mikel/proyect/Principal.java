package com.mikel.proyect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class Principal extends AppCompatActivity implements View.OnClickListener{
    Intent i;
    ImageView img;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        findViewById(R.id.dinero).setOnClickListener(this);
        findViewById(R.id.ropa).setOnClickListener(this);
        findViewById(R.id.juegos).setOnClickListener(this);
        findViewById(R.id.libros).setOnClickListener(this);
        img=(ImageView) findViewById(R.id.imagen);
        if (savedInstanceState != null) {
            bmp = savedInstanceState.getParcelable("bitmap");
            img.setImageBitmap(bmp);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("bitmap", bmp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.dinero:
                //Inform the user the button1 has been clicked
               // i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult(i,0);
                i=new Intent(this,Dinero.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(), "dinero clicked.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ropa:
                //Inform the user the button2 has been clicked
                Toast.makeText(getApplicationContext(), "ropa clicked.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.juegos:
                Toast.makeText(getApplicationContext(), "juegos clicked.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.libros:
                Toast.makeText(getApplicationContext(), "libros clicked.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            Bundle ext = data.getExtras();
            bmp = (Bitmap) ext.get("data");
            img.setImageBitmap(bmp);
        }
    }*/
}
