package test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import data.Database;
import data.Result;
import data.Runner;
import data.Variable;
import gui.InterfaceLog.enumLogType;
import gui.Logs;

/**
 * This class contains main method to test Database access
 * 
 * @author pev
 * @version 1.0.0
 *
 */
public class TestDatabase {
    
    public static void main(String[] args) {

        Logs.logger.addLog(enumLogType.INFO,"========== TEST BDD IN ==========");
        Logs.logger.updateProgress(Logs.logger.getProgressCurrent()+1);

        // --------------------------------------------------------------

        Logs.logger.addLog(enumLogType.INFO,"Init process ----------");

        Logs.logger.addLog(enumLogType.INFO,"\tCreate Database object");
        Database db = new Database("db/database.db");

        Logs.logger.addLog(enumLogType.INFO,"\tDatabase connection");
        db.connect();

        Logs.logger.addLog(enumLogType.INFO,"\tCreate Runner table object");
        Runner run = new Runner(db);

        Logs.logger.addLog(enumLogType.INFO,"\tCreate Variables table object");
        Variable var = new Variable(db);

        Logs.logger.addLog(enumLogType.INFO,"\tCreate Result table object");
        Result res = new Result(db);

     // --------------------------------------------------------------

        Logs.logger.addLog(enumLogType.INFO,"Clear Database ----------");

        Logs.logger.addLog(enumLogType.INFO,"\tRemove all entries in Runner");
        run.clearRunner();
        
        Logs.logger.addLog(enumLogType.INFO,"\tRemove all entreies in Variable");
        var.clearVariable();
        
        Logs.logger.addLog(enumLogType.INFO,"\tRemove all entries in Result");
        res.clearResult();
        
        // --------------------------------------------------------------

        Logs.logger.addLog(enumLogType.INFO,"Runner process ----------");

        Logs.logger.addLog(enumLogType.INFO,"\tAdd Runner entry");
        Date date = new Date();
        run.addEntry(new Timestamp(date.getTime()));
        Logs.logger.addLog(enumLogType.INFO,run.toString());

        Logs.logger.addLog(enumLogType.INFO,"\tAdd Variables entry");
        var.addEntry("tagada", 0, 10, run.getIdRun());
        Logs.logger.addLog(enumLogType.INFO,var.toString());
        var.addEntry("banana", 20, 30, run.getIdRun());
        Logs.logger.addLog(enumLogType.INFO,var.toString());

        Logs.logger.addLog(enumLogType.INFO,"\tAdd Result entry");
        res.addEntry("{ 'p_1':1.01, 'p_2':2.02, 'p_3':3.03 }", 1.10, 1.20, 1.30, run.getIdRun());
        Logs.logger.addLog(enumLogType.INFO,res.toString());
        res.addEntry("{ 'p_1':2.02, 'p_2':3.03, 'p_3':4.04 }", 1.15, 1.25, 1.35, run.getIdRun());
        Logs.logger.addLog(enumLogType.INFO,res.toString());
        res.addEntry("{ 'p_1':3.03, 'p_2':4.04, 'p_3':5.05 }", 1.15, 1.25, 1.35, run.getIdRun());
        Logs.logger.addLog(enumLogType.INFO,res.toString());
        
        Logs.logger.addLog(enumLogType.INFO, "\tUpdate Runner");
        run.setTimeOut(new Timestamp(date.getTime()));
        run.updateEntry();

        // --------------------------------------------------------------

        Logs.logger.addLog(enumLogType.INFO,"Update process ----------");

        Logs.logger.addLog(enumLogType.INFO,"\tEdit Runner entry");
        Logs.logger.addLog(enumLogType.INFO,run.toString());
        run.setTimeIn(new Timestamp(date.getTime()));
        run.updateEntry();
        Logs.logger.addLog(enumLogType.INFO,run.toString());

        Logs.logger.addLog(enumLogType.INFO,"\tEdit Variables entry");
        Logs.logger.addLog(enumLogType.INFO,var.toString());
        var.setName("nounours");
        var.updateEntry();
        Logs.logger.addLog(enumLogType.INFO,var.toString());

        Logs.logger.addLog(enumLogType.INFO,"\tEdit Result entry");
        Logs.logger.addLog(enumLogType.INFO,res.toString());
        res.setResMpfr(10.23);
        res.updateEntry();
        Logs.logger.addLog(enumLogType.INFO,res.toString());

        // --------------------------------------------------------------
        
        Logs.logger.addLog(enumLogType.INFO,"Remove process ----------");

        Logs.logger.addLog(enumLogType.INFO,"\tDelete Runner entry");
        //run.deleteEntry();

        Logs.logger.addLog(enumLogType.INFO,"\tDelete Variables entry");
        //var.deleteEntry();

        Logs.logger.addLog(enumLogType.INFO,"\tDelete Result entry");
        //res.deleteEntry();
        
        // --------------------------------------------------------------
        
        Logs.logger.addLog(enumLogType.INFO,"Tables content ----------");
        
        Logs.logger.addLog(enumLogType.INFO,"\tGet Entries from Runner");
        ArrayList<Runner> lstRun = run.getEntries(db);
        for (Iterator iterator = lstRun.iterator(); iterator.hasNext();) {
            Runner runner = (Runner) iterator.next();
            Logs.logger.addLog(enumLogType.INFO,runner.toString());
        }
        
        Logs.logger.addLog(enumLogType.INFO,"\tGet Entries from Variables");
        ArrayList<Variable> lstVar = var.getEntries(db);
        for (Iterator iterator = lstVar.iterator(); iterator.hasNext();) {
            Variable variable = (Variable) iterator.next();
            Logs.logger.addLog(enumLogType.INFO,variable.toString());
        }
        
        Logs.logger.addLog(enumLogType.INFO,"\tGet Entries from Result");
        ArrayList<Result> lstRes = res.getEntries(db);
        for (Iterator iterator = lstRes.iterator(); iterator.hasNext();) {
            Result result = (Result) iterator.next();
            Logs.logger.addLog(enumLogType.INFO,result.toString());
        }
        
        // --------------------------------------------------------------

        Logs.logger.addLog(enumLogType.INFO,"Clear Database ----------");

        Logs.logger.addLog(enumLogType.INFO,"\tRemove all entries in Runner");
        //run.clearRunner();
        
        Logs.logger.addLog(enumLogType.INFO,"\tRemove all entreies in Variable");
        //var.clearVariable();
        
        Logs.logger.addLog(enumLogType.INFO,"\tRemove all entries in Result");
        //res.clearResult();

        // --------------------------------------------------------------
        
        Logs.logger.addLog(enumLogType.INFO,"========== TEST BDD OUT =========");
        
        Logs.logger.updateProgress(100);

    }

}
