/**
 * TargetCombo.java
 * 
 * Created on Nov 20, 2016, 11:06:46 AM
 * 
 */
package com.cebernal.naruto.model;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Nov 20, 2016
 */
public class TargetCombo {

	private String combo = "";

	public TargetCombo(String combo) {
		super();
		this.combo = combo;
	}

	@Override
	public String toString() {
		return "Target Combo [" + combo + "]";
	}

	public String getCombo() {
		return combo;
	}

	public void setCombo(String combo) {
		this.combo = combo;
	}

}
