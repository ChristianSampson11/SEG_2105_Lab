package com.example.productcatalog_v2021;

import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseProducts;
    EditText editTextName;
    EditText editTextPrice;
    Button buttonAddProduct;
    ListView listViewProducts;

    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        databaseProducts = FirebaseDatabase.getInstance().getReference("products");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        buttonAddProduct = (Button) findViewById(R.id.addButton);

        products = new ArrayList<>();

        //adding an onclicklistener to button
        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });

        listViewProducts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = products.get(i);
                showUpdateDeleteDialog(product.getId(), product.getProductName());
                return true;
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        //attaching value event listener
        databaseProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Clearing the previous artist list
                products.clear();

                //Iterating through all the nodes
                for(DataSnapshot postSnapshot : snapshot.getChildren()){
                    //Getting product
                    Product product = postSnapshot.getValue(Product.class);
                    //Adding product to the list
                    products.add(product);
                }

                //Creating adapter
                ProductList productsAdapter = new ProductList(MainActivity.this, products);
                //Attaching adapter to the listview
                listViewProducts.setAdapter(productsAdapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void showUpdateDeleteDialog(final String productId, String productName) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final EditText editTextPrice  = (EditText) dialogView.findViewById(R.id.editTextPrice);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateProduct);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteProduct);

        dialogBuilder.setTitle(productName);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                double price = Double.parseDouble(String.valueOf(editTextPrice.getText().toString()));
                if (!TextUtils.isEmpty(name)) {
                    updateProduct(productId, name, price);
                    b.dismiss();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProduct(productId);
                b.dismiss();
            }
        });
    }

    private void updateProduct(String id, String name, double price) {

    //Getting the specified product reference
    DatabaseReference dR = FirebaseDatabase.getInstance().getReference("products").child(id);

    //Updating the product
    Product product = new Product(id, name, price);
    dR.setValue(product);

    //Notifying user of success
    Toast.makeText(getApplicationContext(), "Product Updated!", Toast.LENGTH_LONG).show();
    }

    private boolean deleteProduct(String id) {

        //Getting the specified product reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("products").child(id);

        //Removing Product
        dR.removeValue();
        Toast.makeText(getApplicationContext(), "Product Deleted!", Toast.LENGTH_LONG).show();
        return true;
    }

    private void addProduct() {

        //Getting the values to save
        String name = editTextName.getText().toString().trim();
        double price = Double.parseDouble(String.valueOf(editTextPrice.getText().toString()));

        //Checking if the value is provided
        if(!TextUtils.isEmpty(name)){

            //Getting a unique using push().getKey() method.
            //It'll create a unique ID and we'll use it as the primary key for our product.
            String id = databaseProducts.push().getKey();

            //Creating a product object
            Product product = new Product(id, name, price);

            //Saving the product
            databaseProducts.child(id).setValue(product);

            //Clearing the EditText boxes
            editTextName.setText("");
            editTextPrice.setText("");

            //Displaying a success toast
            Toast.makeText(this, "Product Added!", Toast.LENGTH_LONG).show();
        }
        else{

            //Displays a toast for when the value IS NOT given
            Toast.makeText(this, "Please Enter a Product Name:", Toast.LENGTH_LONG).show();
        }
    }
}