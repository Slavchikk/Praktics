package com.example.praktics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    Connection connection;
    String ConnectionResult = "";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoToSetWindow = (Button) findViewById(R.id.btnGoToSetWindow);



        View.OnClickListener clckGoToSetWindow = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,setProduct.class);
                startActivity(intent);
            }
        };



        btnGoToSetWindow.setOnClickListener(clckGoToSetWindow);





    }

    public void GetTextFrommSql(View v)
    {

        TextView ID = findViewById(R.id.txtID);
        TextView Title = findViewById(R.id.txtTitle);
        TextView Count = findViewById(R.id.txtCount);


        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();

            if (connection!=null)
            {
                String query = "SELECT * FROM Products";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);


                while (resultSet.next())
                {

                    ID.setText(resultSet.getString(  1));
                    Title.setText(resultSet.getString(  2));
                    Count.setText(resultSet.getString(  3));

                }
            }
            else
            {
                ConnectionResult="Check Connection";
            }

        }
        catch (Exception ex)
        {


        }

    }


}
