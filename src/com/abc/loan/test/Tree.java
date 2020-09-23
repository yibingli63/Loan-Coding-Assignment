package com.abc.loan.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import java.io.IOException;
import java.io.Writer;

import com.abc.loan.data.Loan;
import com.abc.loan.data.LoanType;
import com.abc.loan.data.Payment;
import com.abc.loan.delegate.LoanDelegate;

public class Tree {

	    private final static int ROOT = 0;

	    private static HashMap<String, Node> nodes = new HashMap<String, Node>(); // static is important

	    // Properties
	    public HashMap<String, Node> getNodes() {
	        return (HashMap<String, Node>) nodes;
	    }

	    // Public interface
	    public Node addNode(String identifier) {
	        return this.addNode(identifier, null);
	    }

	    public Node addNode(String identifier, String parent) {
	    	Node node = new Node(identifier);
	        nodes.put(identifier, node);
       
	        if (parent != null) {
	        	nodes.get(parent).addChild(identifier);
	      } 

	        return node;
	    }
	    
	    TreeMap<String, LoanType> nodeMap = new TreeMap<String, LoanType>();
	    
	    @SuppressWarnings("unchecked")
		public void buildNodeSet(String parent) throws Exception{
	    	List<LoanType> loanTypeLists = new ArrayList<LoanType>();
	    	loanTypeLists =  LoanDelegate.getLoanTypes();
			Map.Entry<String, LoanType> temp = null;
	
			for (int i=0; i<loanTypeLists.size(); i++){			
		 		temp =(Entry<String, LoanType>) loanTypeLists.get(i);
	
				if (!temp.getKey().equals("ALL")) {
					nodeMap.put(temp.getKey(), temp.getValue());
				}		
	    	}
			
	    }
	    
	    @SuppressWarnings("unchecked")
		public void displayNodeSet(String identifier, int depth, Writer out) throws Exception {
	    	    Loan loan = new Loan(null, null, null, null, null, 0, 0);
		        List<Loan> reportLists = new ArrayList<Loan>();
				reportLists = LoanDelegate.getLoans();
				Boolean titlePrinted = true;
				
				for(Map.Entry<String, LoanType> m:nodeMap.entrySet()) {	
					for (int i = 0; i<reportLists.size(); i++ ) {						
						loan = reportLists.get(i);	
															
						if (loan.getLoanType().getId().equals(m.getKey())) {													
							if (titlePrinted) {
								System.out.println(loan.getLoanType().getName());
								System.out.println("--------------------------------------------");

								out.append(loan.getLoanType().getName()).append("\r\n");
								out.append("--------------------------------------------").append("\r\n");
								titlePrinted = false;
							}							
							showLoanDetails(loan, "");
							writeLoanDetails(loan, "", out);
						} 		
					}
		            
		            System.out.println();
		            titlePrinted = true;
	       
				}        
				
		    }
	    
		@SuppressWarnings("unchecked")
		public void buildTree(String parent) throws Exception{
	    	Tree tree = new Tree();
	    	List<LoanType> loanTypeLists = new ArrayList<LoanType>();
	    	loanTypeLists =  LoanDelegate.getLoanTypes();	
	    	String loanTypeId = null;
			String parentLoanTypeId = null;	    
			Map.Entry<String, LoanType> temp = null;
			LoanType loanType = new LoanType();			
			List<String> children = new ArrayList<String>();			
						
			for (int i=0; i<loanTypeLists.size(); i++){
			
		 		temp =(Entry<String, LoanType>) loanTypeLists.get(i);
				loanTypeId = temp.getKey();
		
				if (loanTypeId != "ALL") {
					loanType = LoanDelegate.getLoanType(loanTypeId);
					parentLoanTypeId = loanType.getParentType().getId();
			
					if (parentLoanTypeId.equals(parent)){
						children.add(loanTypeId);
						tree.addNode(loanTypeId, parentLoanTypeId);
					}
				}
	    	}
		
	    	for (String child : children) {
	    		 this.buildTree(child);
	    	}
	    }
	    
	    public void display(String identifier) throws Exception {
	        this.display(identifier, ROOT, null);
	    }

	    @SuppressWarnings("unchecked")
		public void display(String identifier, int depth, Writer out) throws Exception {
	        ArrayList<String> children = nodes.get(identifier).getChildren();
	        
	        Loan loan = new Loan(null, null, null, null, null, 0, 0);
	        List<Loan> reportLists = new ArrayList<Loan>();
			
			reportLists = LoanDelegate.getLoans();

	        if (depth == ROOT) {
	           	System.out.println("Loans By Types");
	            System.out.println("--------------------------------------------");
	            System.out.println("All Loan Types");
	            System.out.println("--------------------------------------------");
	            out.append("Loans By Types").append("\r\n");
	            out.append("--------------------------------------------").append("\r\n");
	            out.append("All Loan Types").append("\r\n");
	            out.append("--------------------------------------------").append("\r\n");
	        } else {
	            String tabs = String.format("%0" + depth + "d", 0).replace("0", "    "); // 4 spaces
	            System.out.println(tabs + nodes.get(identifier).getIdentifier() + " Loans");
	            System.out.println(tabs + "--------------------------------------------");
	            out.append(tabs + nodes.get(identifier).getIdentifier() + " Loans").append("\r\n");
	            out.append(tabs + "--------------------------------------------").append("\r\n");
	            
	            for (int i=0; i<reportLists.size(); i++ ){
					loan = reportLists.get(i);
					if (loan.getLoanType().getId().equals(identifier)) {
						showLoanDetails(loan, tabs);
						writeLoanDetails(loan, tabs, out);
					} 		
				}   
	            System.out.println();
	        }
	        
	        depth++;
	        
	        for (String child : children) {
	            // Recursive call
	            this.display(child, depth, out);
	        }
	    }
	    
	    
	    @SuppressWarnings("unchecked")
		public void buildTree1(String parent) throws Exception{
	    	Tree tree = new Tree();
	    	List<LoanType> loanTypeLists = new ArrayList<LoanType>();
	    	loanTypeLists =  LoanDelegate.getLoanTypes();
	    	String loanTypeId = null;
			String parentLoanTypeId = null;	    	
			Map.Entry<String, LoanType> temp = null;
			LoanType loanType = new LoanType();
			List<String> children = new ArrayList<String>();
	
			for (int i=0; i<loanTypeLists.size(); i++){
			    temp =(Entry<String, LoanType>) loanTypeLists.get(i);
				loanTypeId = temp.getKey();
							
				if (loanTypeId != "ALL") {
					loanType = LoanDelegate.getLoanType(loanTypeId);
					parentLoanTypeId = loanType.getParentType().getId();
			
					if (parentLoanTypeId.equals(parent)){
						children.add(loanTypeId);
						tree.addNode(loanTypeId, parentLoanTypeId);
					}
				}
	    	}
			
	    	 for (String child : children) {
	    		 this.buildTree1(child);
	    	 }
	    }
	    
	    public void display1(String identifier) throws Exception {
	        this.display1(identifier, ROOT, null);
	    }
	    
	    @SuppressWarnings("unchecked")
		public void display1(String identifier, int depth, Writer out) throws Exception {
	        ArrayList<String> children = nodes.get(identifier).getChildren();
                                                                                                                                                                
            Loan loan = new Loan(null, null, null, null, null, 0, 0);
	        List<Loan> reportLists = new ArrayList<Loan>();
			
			reportLists = LoanDelegate.getLoans();
			Boolean titlePrinted = true;
						
	            for (int i=0; i<reportLists.size(); i++ ){
					loan = reportLists.get(i);
							
					if (loan.getLoanType().getId().equals(identifier)) {
												
						if (titlePrinted) {
							System.out.println(loan.getLoanType().getName());
							System.out.println("--------------------------------------------");

							out.append(loan.getLoanType().getName()).append("\r\n");
							out.append("--------------------------------------------").append("\r\n");
							titlePrinted = false;
						}
						
						showLoanDetails(loan, "");
						writeLoanDetails(loan, "", out);
					} 		
				}
	            
	            System.out.println();
	            titlePrinted = true;
       
	        depth++;
        
	        for (String child : children) {
	            this.display1(child, depth, out);
	        }	    
	    }

	    public void showLoanDetails(Loan loan, String tabs){
			double balance;
		
			System.out.println(tabs + tabs + "Loan ID:       " + loan.getId());
			System.out.println(tabs + tabs + "Lendor:        " + loan.getLender().getFullName());
			System.out.println(tabs + tabs + "Borrower:      " + loan.getBorrower().getFullName());
			System.out.println(tabs + tabs + "Loan Date:     " + new SimpleDateFormat("MM-dd-yyyy").format(loan.getDate()));
			System.out.println(tabs + tabs + "Loan Amount:   " + loan.getAmount());
			balance = loan.getAmount() - sumPayments(loan);
			System.out.println(tabs + tabs + "Loan Balance:  " + balance);
			System.out.println(tabs + tabs + "--------------------------------------------------------");	
		}	
	    
	    public void writeLoanDetails(Loan loan, String tabs, Writer out) throws IOException{
			double balance;
		
			out.append(tabs + tabs + "Loan ID:       " + loan.getId()).append("\r\n");
			out.append(tabs + tabs + "Lendor:        " + loan.getLender().getFullName()).append("\r\n");
			out.append(tabs + tabs + "Borrower:      " + loan.getBorrower().getFullName()).append("\r\n");
			out.append(tabs + tabs + "Loan Date:     " + new SimpleDateFormat("MM-dd-yyyy").format(loan.getDate())).append("\r\n");
			out.append(tabs + tabs + "Loan Amount:   " + loan.getAmount()).append("\r\n");
			balance = loan.getAmount() - sumPayments(loan);
			out.append(tabs + tabs + "Loan Balance:  " + balance).append("\r\n");
			out.append(tabs + tabs + "--------------------------------------------------------").append("\r\n");	
		}	
	    
	    public static double sumPayments(Loan loan){
			double sumPayments = 0;
			Payment payment = new Payment(loan, null, null, 0);			
			List paymentList = new ArrayList();
			
			try {
				paymentList = LoanDelegate.getPayments(loan);
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (int i=0; i<paymentList.size(); i++){
				payment = (Payment) paymentList.get(i);
				sumPayments = sumPayments + payment.getAmount();
			}
			return sumPayments;
		}
}