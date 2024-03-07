package pairprogramming.restaurant2;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.text.NumberFormat;

public class TotalCore extends Tab {
    private Label Total,Tax,SubLbl;
    private Button compute, cash,card,Paypal;
    private double TAX = .10, subTotal = 0, totalAmount;

    MainCore mc = new MainCore(); BeveCore bc = new BeveCore(); SideCore sc = new SideCore();

    NumberFormat nf = NumberFormat.getCurrencyInstance();
    NumberFormat pf = NumberFormat.getPercentInstance();

    public TotalCore(MainCore mca, BeveCore bca, SideCore sca){
        this.mc = mca; this.bc = bca; this.sc = sca;


        subTotal = (mc.getSubtotal() + bc.getSubtotal() + sc.getSubtotal());

        Font f1 = new Font("Arial", 20);
        SubLbl = new Label("Subtotal: " + nf.format(subTotal));
        SubLbl.setFont(f1);

        Tax = new Label("Tax: " + pf.format(TAX));
        Tax.setFont(f1);

        Total = new Label("Total: " + nf.format(getTotal()));
        Total.setFont(f1);


        compute = new Button("Compute Total Amount");
        compute.setOnAction(this::compute);
        compute.setMinWidth(150);
        compute.setFont(f1);

        cash = new Button("Cash");
        cash.setOnAction(this::makePayment);
        cash.setMinWidth(compute.getMinWidth());
        cash.setFont(f1);

        card = new Button("Card");
        card.setOnAction(this::makePayment);
        card.setMinWidth(compute.getMinWidth());
        card.setFont(f1);

        Paypal = new Button("Paypal");
        Paypal.setOnAction(this::makePayment);
        Paypal.setMinWidth(compute.getMinWidth());
        Paypal.setFont(f1);


        VBox all = new VBox(SubLbl,Tax,Total, compute, cash,card,Paypal);
        all.setAlignment(Pos.TOP_CENTER);
        all.setSpacing(30);

        setClosable(false);
        setContent(all);
        setText("Payment");
    }

    public void makePayment(ActionEvent event) {
        Alert msg = new Alert(Alert.AlertType.CONFIRMATION);
        msg.setContentText("Are you sure you would like to go through the payment?");
        msg.setTitle("Payment Submission");
        msg.setHeaderText("Confirm Payment");
        msg.showAndWait();
    }
    public void compute(ActionEvent event) {
        Button btn = (Button)event.getSource();

        if (btn == compute) {
            setSubtotal();
            setTotal();

            System.out.println(getSubtotal());
        }
    }

    public double getTotal() {
        return totalAmount;
    }

    public void setTotal() {
        totalAmount = getSubtotal() - (TAX * getSubtotal());
        Total.setText("Total: " + nf.format(getTotal()));
    }

    public double getSubtotal() {
        return subTotal;
    }

    public void setSubtotal() {
        subTotal = mc.getSubtotal() + bc.getSubtotal() + sc.getSubtotal();
        SubLbl.setText("Subtotal: " + nf.format(getSubtotal()));
    }
}
