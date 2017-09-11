/**
 * 
 */
package main.java;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sushant.tirodkar
 *
 */

@XmlRootElement(name = "expense")
public class Expense {

	private double expenesAmount;
	private String description;
	private String expenseCategory;

	public Expense() {
		super();
	}

	public Expense(double expenesAmount, String description, String expenseCategory) {
		super();
		this.expenesAmount = expenesAmount;
		this.description = description;
		this.expenseCategory = expenseCategory;
	}

	@XmlElement
	public double getExpenesAmount() {
		return expenesAmount;
	}

	public void setExpenesAmount(double expenesAmount) {
		this.expenesAmount = expenesAmount;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

}
