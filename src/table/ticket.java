/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

/**
 *
 * @author asksoft
 */
public class ticket {

    //{"Sr.No":1,"Ticket":"ask5eaaab95cb362","Amount":"112.00","Draw Id":"25","Draw Time":"16:15:00","Date":"2020-04-30"}
    public String srno;
    public String ticket;
    public String amount;
    public String drawid;
    public String drawtime;
    public String date;

    public void setSrno(String srno) {
        this.srno = srno;
    }

    public String getSrno() {
        return this.srno;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setDrawid(String drawid) {
        this.drawid = drawid;
    }

    public String getDrawid() {
        return this.drawid;
    }

    public void setDrawtime(String drawtime) {
        this.drawtime = drawtime;
    }

    public String getDrawtime() {
        return this.drawtime;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }
}
