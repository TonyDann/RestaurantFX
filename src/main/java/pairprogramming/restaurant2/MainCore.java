package pairprogramming.restaurant2;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.text.NumberFormat;

public class MainCore extends Tab {
    private Label sizeOption,Protein,Starch,Gravy,Veggies,NumofMeals,Total1;
    private RadioButton Personal,Small,Medium,Large,
            bbqChicken,bChicken,ssTofu,jTofu,sFish,
            RandP,festival,Gr,YandD,FF;
    private CheckBox Cel,Pep,Tan,SS,SF,
            AH,RG,RRP,RO,SDT,FT,OL,Mush,Egg,AR;

    private double subTotal = 0, protein = 0, starch = 0, gravy = 0, size = 1, sides = 0;

    private ToggleGroup meatGroup = new ToggleGroup(), starchGroup = new ToggleGroup(), sizeGroup = new ToggleGroup();
    private final Font mcF = new Font("Helvetica", 15);

    public MainCore(){

        // Size Options
        sizeOption = new Label("Size: ");
        sizeOption.setFont(mcF);


        Personal = new RadioButton("Personal");
        Personal.setOnAction(this::RadioAction);

        Small = new RadioButton("Small");
        Small.setOnAction(this::RadioAction);

        Medium = new RadioButton("Medium");
        Medium.setOnAction(this::RadioAction);

        Large = new RadioButton("Large");
        Large.setOnAction(this::RadioAction);

        sizeGroup.getToggles().addAll(Personal,Small,Medium,Large);

        for (Toggle rb : sizeGroup.getToggles()) {
            RadioButton rb2 = (RadioButton) rb;
            rb2.setFont(mcF);
        }

        HBox Soptions = new HBox(sizeOption,Personal,Small,Medium,Large);
        Soptions.setAlignment(Pos.TOP_CENTER);
        Soptions.setSpacing(20);

        //Meat
        Protein = new Label("Protein");
        Protein.setFont(mcF);

        bbqChicken = new RadioButton("BBQ Chicken");
        bbqChicken.setOnAction(this::RadioAction);

        bChicken = new RadioButton("Baked Chicken");
        bChicken.setOnAction(this::RadioAction);

        ssTofu = new RadioButton("Sweet & Sour Tofu");
        ssTofu.setOnAction(this::RadioAction);

        jTofu = new RadioButton("Jerked Tofu");
        jTofu.setOnAction(this::RadioAction);

        sFish = new RadioButton("Steamed Fish");
        sFish.setOnAction(this::RadioAction);

        meatGroup.getToggles().addAll(bbqChicken,bChicken,ssTofu,jTofu,sFish);

        for (Toggle rb : meatGroup.getToggles()) {
            RadioButton rb2 = (RadioButton) rb;
            rb2.setFont(mcF);
        }

        VBox MeatOp = new VBox(Protein,bbqChicken,bChicken,ssTofu,jTofu,sFish);
        MeatOp.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(10),BorderWidths.DEFAULT)));
        MeatOp.setPadding(new Insets(10,10,10,10));
        MeatOp.setSpacing(20);

        // Starch
        Starch = new Label("Starch");
        Starch.setFont(mcF);

        RandP = new RadioButton("Rice & Peas");
        RandP.setOnAction(this::RadioAction);

        festival = new RadioButton("Festival");
        festival.setOnAction(this::RadioAction);

        Gr = new RadioButton("Garden Rice");
        Gr.setOnAction(this::RadioAction);

        YandD = new RadioButton("Yam & Dumpling");
        YandD.setOnAction(this::RadioAction);

        FF = new RadioButton("French Fries");
        FF.setOnAction(this::RadioAction);

        starchGroup.getToggles().addAll(RandP,festival,Gr,YandD,FF);

        for (Toggle rb : starchGroup.getToggles()) {
            RadioButton rb2 = (RadioButton) rb;
            rb2.setFont(mcF);
        }

        VBox Sop = new VBox(Starch,RandP,festival,Gr,YandD,FF);
        Sop.setBorder(MeatOp.getBorder());
        Sop.setPadding(MeatOp.getPadding());
        Sop.setSpacing(20);

        // Gravy
        Gravy = new Label("Gravy");
        Gravy.setFont(mcF);

        Cel = new CheckBox("Celery");
        Cel.setOnAction(this::CheckAction);

        Pep = new CheckBox("Pepper");
        Pep.setOnAction(this::CheckAction);

        Tan = new CheckBox("Tangy");
        Tan.setOnAction(this::CheckAction);

        SS = new CheckBox("Sweet Sauce");
        SS.setOnAction(this::CheckAction);

        SF = new CheckBox("Smoked FLovor");
        SF.setOnAction(this::CheckAction);

        VBox Gop = new VBox(Gravy,Cel,Pep,Tan,SS,SF);

        for (int i = 1; i < Gop.getChildren().size(); i++) {
            Node cb = Gop.getChildren().get(i);
            CheckBox cb2 = (CheckBox)cb;
            cb2.setFont(mcF);
        }

        Gop.setBorder(MeatOp.getBorder());
        Gop.setPadding(MeatOp.getPadding());
        Gop.setSpacing(20);

        HBox OPTIONS = new HBox(MeatOp,Sop,Gop);
        OPTIONS.setAlignment(Pos.CENTER);
        OPTIONS.setSpacing(10);

        //Toppings
        Veggies = new Label("Veggies");
        Veggies.setFont(mcF);

        AH = new CheckBox("Artichoke Hearts");
        AH.setOnAction(this::CheckAction);

        RG = new CheckBox("Roasted Garlic");
        RG.setOnAction(this::CheckAction);

        RRP = new CheckBox("Roasted Red Pepper");
        RRP.setOnAction(this::CheckAction);

        RO = new CheckBox("Red Onion");
        RO.setOnAction(this::CheckAction);

        SDT = new CheckBox("Sun-dried Tomatos");
        SDT.setOnAction(this::CheckAction);

        FT = new CheckBox("Fresh Tomatos");
        FT.setOnAction(this::CheckAction);

        OL = new CheckBox("Olives");
        OL.setOnAction(this::CheckAction);

        Mush = new CheckBox("Mushroom");
        Mush.setOnAction(this::CheckAction);

        Egg = new CheckBox("Eggplant");
        Egg.setOnAction(this::CheckAction);

        AR = new CheckBox("Aruguia");
        AR.setOnAction(this::CheckAction);

        VBox top1 = new VBox(Veggies,AH,RG,RRP,RO,SDT);
        top1.setSpacing(20);
        VBox top2 = new VBox(FT,OL,Mush,Egg,AR);
        top2.setSpacing(20);
        top2.setPadding(new Insets(mcF.getSize() + top1.getSpacing(), 0, 0, 0));

        for (int i = 1; i < top1.getChildren().size(); i++) {
            Node cb = top1.getChildren().get(i);
            CheckBox cb2 = (CheckBox)cb;
            cb2.setFont(mcF);
        }

        for (int i = 0; i < top2.getChildren().size(); i++) {
            Node cb = top2.getChildren().get(i);
            CheckBox cb2 = (CheckBox)cb;
            cb2.setFont(mcF);
        }

        HBox Voptions = new HBox(top1,top2);
        Voptions.setBorder(MeatOp.getBorder());
        Voptions.setPadding(MeatOp.getPadding());
        Voptions.setAlignment(Pos.CENTER);
        Voptions.setSpacing(10);

        //TOTAL
        Label CurrOrder = new Label("Current Order Details:");
        CurrOrder.setAlignment(Pos.BASELINE_LEFT);
        CurrOrder.setPadding(new Insets(0));
        //CurrOrder.setFont(mcF);

        NumofMeals = new Label("");
        Total1 = new Label("Total Price For Main Course: ");

        VBox TotalB = new VBox(Total1);
        TotalB.setAlignment(Pos.BASELINE_CENTER);
        TotalB.setSpacing(10);
        TotalB.setPadding(new Insets(0, 0, 30, 20));
        for (Node lbl : TotalB.getChildren()) {
            Label lbl2 = (Label)lbl;
            lbl2.setFont(mcF);
        }


        // All NODES
        VBox all = new VBox(Soptions,OPTIONS,Voptions,TotalB);
        all.setSpacing(15);
        all.setFillWidth(true);


        setContent(all);
        setText("Main Course");
    }

    // Radio Button EventHandler
    public void RadioAction(ActionEvent event){
        RadioButton rBtn = (RadioButton) event.getSource();

        if (rBtn.getToggleGroup() == meatGroup) {
            switch (rBtn.getParent().getChildrenUnmodifiable().indexOf(rBtn)) {
                case 1: {
                    protein = 260;
                    break;
                }
                case 2: {
                    protein = 240;
                    break;
                }
                case 3: {
                    protein = 220;
                    break;
                }
                case 4: {
                    protein = 250;
                    break;
                }
                case 5: {
                    protein = 300;
                    break;
                }
                default: protein = 0;
            }
        } else if (rBtn.getToggleGroup() == starchGroup){
            switch (rBtn.getParent().getChildrenUnmodifiable().indexOf(rBtn)) {
                case 1: {
                    starch = 26;
                    break;
                }
                case 2: {
                    starch = 24;
                    break;
                }
                case 3: {
                    starch = 22;
                    break;
                }
                case 4: {
                    starch = 25;
                    break;
                }
                case 5: {
                    starch = 30;
                    break;
                }
                default: starch = 0;
            }
        } else if (rBtn.getToggleGroup() == sizeGroup) {
            switch (rBtn.getParent().getChildrenUnmodifiable().indexOf(rBtn)) {
                case 1: {
                    size = 1;
                    break;
                }
                case 2: {
                    size = 1.2;
                    break;
                }
                case 3: {
                    size = 1.4;
                    break;
                }
                case 4: {
                    size = 1.5;
                    break;
                }
                default: size = 1;
            }
        }

        setSubtotal();
    }



    // CheckBox EventHandler
    public void CheckAction(ActionEvent event){
        CheckBox ckb = (CheckBox)event.getSource();
        if (ckb.isSelected()) {
            sides += 20;
        } else if (!ckb.isSelected()) {
            sides -= 20;
        }
        setSubtotal();

    }

    public void setSubtotal() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        subTotal = ((protein + starch + gravy) * size) + sides;
        Total1.setText("Current Main Course Total: " + nf.format(subTotal));
        //NumofMeals.setText("Number of Meals: " + 1);

    }

    public double getSubtotal() {
        return subTotal;
    }
}

