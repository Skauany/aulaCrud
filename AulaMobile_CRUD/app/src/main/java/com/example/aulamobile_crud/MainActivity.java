package com.example.aulamobile_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText editTextCode, editTextValue;
    private TextView textViewResult;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCode = findViewById(R.id.editTextCode);
        editTextValue = findViewById(R.id.editTextValue);
        textViewResult = findViewById(R.id.textViewResult);
        db = FirebaseFirestore.getInstance();

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonUpdate = findViewById(R.id.buttonUpdate);
        Button buttonDelete = findViewById(R.id.buttonDelete);
        Button buttonSearch = findViewById(R.id.buttonSearch);

        buttonAdd.setOnClickListener(v -> addProduct());
        buttonUpdate.setOnClickListener(v -> updateProduct());
        buttonDelete.setOnClickListener(v -> deleteProduct());
        buttonSearch.setOnClickListener(v -> searchProduct());
    }

    private void addProduct() {
        String code = editTextCode.getText().toString().trim();
        String value = editTextValue.getText().toString().trim();

        if (code.isEmpty() || value.isEmpty()) {
            showMessage("Por favor, preencha todos os campos.");
            return;
        }

        Map<String, String> product = new HashMap<>();
        product.put("value", value);

        db.collection("Produtos")
                .document(code)
                .set(product)
                .addOnSuccessListener(aVoid -> {
                    Log.d("TAG", "Produto cadastrado com ID: " + code);
                    showMessage("Produto cadastrado com sucesso.");
                })
                .addOnFailureListener(e -> {
                    Log.w("TAG", "Erro ao cadastrar produto", e);
                    showMessage("Erro ao cadastrar produto: " + e.getMessage());
                });
    }

    private void searchProduct() {
        String code = editTextCode.getText().toString().trim();

        if (code.isEmpty()) {
            showMessage("Por favor, insira o código do produto.");
            return;
        }

        db.collection("Produtos").document(code).get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String value = documentSnapshot.getString("value");
                        editTextValue.setText(value);
                        showMessage("Produto encontrado.");
                    } else {
                        showMessage("Produto não encontrado.");
                    }
                })
                .addOnFailureListener(e -> {
                    Log.w("TAG", "Erro ao buscar produto", e);
                    showMessage("Erro ao buscar produto: " + e.getMessage());
                });
    }

    private void updateProduct() {
        String code = editTextCode.getText().toString().trim();
        String value = editTextValue.getText().toString().trim();

        if (code.isEmpty() || value.isEmpty()) {
            showMessage("Por favor, preencha todos os campos.");
            return;
        }

        Map<String, String> product = new HashMap<>();
        product.put("value", value);

        db.collection("Produtos").document(code)
                .set(product)
                .addOnSuccessListener(aVoid -> {
                    Log.d("TAG", "Produto atualizado com ID: " + code);
                    showMessage("Produto atualizado com sucesso.");
                })
                .addOnFailureListener(e -> {
                    Log.w("TAG", "Erro ao atualizar produto", e);
                    showMessage("Erro ao atualizar produto: " + e.getMessage());
                });
    }

    private void deleteProduct() {
        String code = editTextCode.getText().toString().trim();

        if (code.isEmpty()) {
            showMessage("Por favor, insira o código do produto.");
            return;
        }

        db.collection("Produtos").document(code).delete()
                .addOnSuccessListener(aVoid -> {
                    Log.d("TAG", "Produto deletado com ID: " + code);
                    showMessage("Produto deletado com sucesso.");
                })
                .addOnFailureListener(e -> {
                    Log.w("TAG", "Erro ao deletar produto", e);
                    showMessage("Erro ao deletar produto: " + e.getMessage());
                });
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}