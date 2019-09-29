package controllers;
import play.*;
import play.mvc.*;
import java.util.*;
import models.*;
public class Application extends Controller {
	// Redirecionadores de páginas meio termo
    public static void index() {render();}
    public static void home() {render();}
    public static void calculadora() {render();}
    public static void optfut() {render();}
    public static void optprev() {render();}
    public static void welcome() {render();}
    public static void futValBruto() {render();}
    public static void preValBruto() {render();}
    public static void preValPercent() {render();}
    
    // Redirecionadores de formularios de calculo
    public static void poupBruto() {render("Calculadora/poupBruto.html");}
    public static void cdb() {render("Calculadora/cdb.html");}
    public static void preFix() {render("Calculadora/preFix.html");}
    public static void rendPrev() {render("Calculadora/rendPrev.html");}
    public static void selicBruto() {render("Calculadora/selicBruto.html");}
    public static void selicPerCent() {render("Calculadora/selicPerCent.html");}
    public static void preCalcBruto() {render("Calculadora/preCalcBruto.html");}
    public static void preCalcCent() {render("Calculadora/preCalcCent.html");}
}