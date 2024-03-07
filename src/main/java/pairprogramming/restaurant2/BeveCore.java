package pairprogramming.restaurant2;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;

import java.text.NumberFormat;

public class BeveCore extends Tab {
    private Label bever,Quantity,FP,Pu,Drp,SP,Lemon,RL,Water,NumofMeals,Total;
    private TextField input1,input2,input3,input4,input5,input6,input7;
    private final Font bcF = new Font("Helvetica", 20);

    private double subTotal;

    public BeveCore(){
        bever = new Label("BEVERAGES");
        bever.setFont(bcF);
        bever.setPadding(new Insets(0, 50 ,0, 0));

        Quantity =new Label("Quantity");
        Quantity.setFont(bcF);

        HBox la =new HBox(bever,Quantity);
        la.setSpacing(200);
        la.setAlignment(Pos.TOP_RIGHT);


        // BEVERAGES
        FP =new Label("Fruit Punch");
        input1 = new TextField("0");
        input1.setOnAction(this::TextAction);
        input1.setId("50");
        HBox field1 = new HBox(FP,input1);
        field1.setSpacing(la.getSpacing());
        field1.setAlignment(la.getAlignment());

        Pu = new Label("PepUp");
        input2 = new TextField("0");
        input2.setOnAction(this::TextAction);
        input2.setId("40");
        HBox field2 = new HBox(Pu,input2);
        field2.setAlignment(field1.getAlignment());
        field2.setSpacing(field1.getSpacing());

        Drp = new Label("Dr.Pepper");
        input3 = new TextField("0");
        input3.setOnAction(this::TextAction);
        input3.setId("60");
        HBox field3 = new HBox(Drp,input3);
        field3.setSpacing(field1.getSpacing());
        field3.setAlignment(field1.getAlignment());

        SP = new Label("Sprite");
        input4 = new TextField("0");
        input4.setOnAction(this::TextAction);
        input4.setId("40");
        HBox field4 = new HBox(SP,input4);
        field4.setAlignment(field1.getAlignment());
        field4.setSpacing(field1.getSpacing());

        Lemon = new Label("Lemonade");
        input5 = new TextField("0");
        input5.setOnAction(this::TextAction);
        input5.setId("80");
        HBox field5 = new HBox(Lemon,input5);
        field5.setSpacing(field1.getSpacing());
        field5.setAlignment(field1.getAlignment());

        RL = new Label("Raspberry Lemonade");
        input6 = new TextField("0");
        input6.setOnAction(this::TextAction);
        input6.setId("30");
        HBox field6 = new HBox(RL,input6);
        field6.setAlignment(field1.getAlignment());
        field6.setSpacing(field1.getSpacing());

        Water = new Label("Bottled Water");
        input7 = new TextField("0");
        input7.setOnAction(this::TextAction);
        input7.setId("50");
        HBox field7 = new HBox(Water,input7);
        field7.setSpacing(field1.getSpacing());
        field7.setAlignment(field1.getAlignment());

        // TOTAL
        Label CurrOrder = new Label("Current Order Details: ");
        CurrOrder.setAlignment(Pos.CENTER);
        CurrOrder.setPadding(new Insets(0));
        CurrOrder.setFont(bcF);


        NumofMeals = new Label("Number of Meals: ");
        Total = new Label("Total Price of Beverages: ");
        Total.setFont(bcF);

        VBox TotalB = new VBox(Total);
        TotalB.setAlignment(Pos.BASELINE_CENTER);
        TotalB.setSpacing(10);


        VBox all = new VBox(la,field1,field2,field3,field4,field5,field6,field7,TotalB);
        all.setSpacing(30);

        for (Node node : all.getChildren()) {
            if (node.getClass() == HBox.class) {
                HBox hb = (HBox)node;
                for (Node node2 : hb.getChildren()) {
                    if (node2.getClass() == Label.class) {
                        Label lbl = (Label)node2;
                        lbl.setFont(bcF);
                    } else if (node2.getClass() == TextField.class) {
                        TextField tf = (TextField)node2;
                        tf.setFont(bcF);
                    }
                }
            }
        }

        HBox all2 = new HBox(all);
        all2.setAlignment(Pos.CENTER);


        setContent(all2);
        setText("Beverages");
    }
    // TextField ActionEvent
    public void TextAction(ActionEvent event){
        TextField input = (TextField)event.getSource();

        setSubtotal();
    }

    public void setSubtotal() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        subTotal = (
                Double.parseDouble(input1.getId()) * Integer.parseInt(input1.getText())
                + Double.parseDouble(input2.getId()) * Integer.parseInt(input2.getText())
                + Double.parseDouble(input3.getId()) * Integer.parseInt(input3.getText())
                + Double.parseDouble(input4.getId()) * Integer.parseInt(input4.getText())
                + Double.parseDouble(input5.getId()) * Integer.parseInt(input5.getText())
                + Double.parseDouble(input6.getId()) * Integer.parseInt(input6.getText())
                + Double.parseDouble(input7.getId()) * Integer.parseInt(input7.getText())
                );

        Total.setText("Beverages Total: " + nf.format(getSubtotal()));
       // NumofMeals.setText("Number of Meals: " + 1);
    }

    public double getSubtotal() {
        return subTotal;
    }
}
