package com.example.sud.justjava2;
/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int pricePerCup = 5;
    boolean addWhippedCream;
    boolean addChocolate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateWeatherMessage(35, "Berlin");

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        if (quantity<10)
            quantity += 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity>0)
            quantity -= 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        displayMessage(CreateOrderSummery());
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice() {
        int price = pricePerCup;
        if(addWhippedCream)
            price += 1;
        if(addChocolate)
            price += 2;
        return quantity * price;
    }

    /**
     * This method displays the order summary
     */
    private String CreateOrderSummery() {
        return "Name: "+ CustomerName() + whippedCream() + Chocolate() + "\nQuantity:" +quantity + "\nTotal : $" + calculatePrice() + "\nThankYou!";
    }
    /**
     * Method t get the customer name from input field
     */
     private String CustomerName()
     {
         EditText personName = (EditText) findViewById(R.id.name_input);
         return personName.getText().toString();
     }
    /**
     *Method to add whipped cream checkbox
     */
    private String whippedCream() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        addWhippedCream = checkBox.isChecked();
        return "\nAdd Whipped Cream? " + addWhippedCream;
    }
    /**
     *Method to add whipped cream checkbox
    */
    private String Chocolate()
    {
        CheckBox checkBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        addChocolate = checkBox.isChecked();
        return "\nAdd Chocolate? " + addChocolate;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

/*    *//**
     * This method displays the given price on the screen.
     *//*
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * this method displays the temperature of a city
     *
     * @param temperature of the city
     * @param cityName    of the city
     */
    private String CreateWeatherMessage(int temperature, String cityName) {
        return "Welcome to" + cityName + " where the temperature is " + temperature + "F";
    }

}
