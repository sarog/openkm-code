/**
 *  OpenKM, Open Document Management System (http://www.openkm.com)
 *  Copyright (c) 2006-2015  Paco Avila & Josep Llort
 *
 *  No bytes were intentionally harmed during the development of this application.
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.openkm.frontend.client.util.validator;

import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.openkm.frontend.client.Main;

import eu.maydu.gwt.validation.client.ValidationAction;
import eu.maydu.gwt.validation.client.ValidationResult;
import eu.maydu.gwt.validation.client.Validator;
import eu.maydu.gwt.validation.client.i18n.ValidationMessages;

/**
 * DecimalValidator
 * 
 * @author jllort
 *
 */
public class DecimalValidator extends Validator<DecimalValidator> {

	private TextBoxBase textBox = null;
	private SuggestBox suggestBox = null;
	
	public DecimalValidator(TextBoxBase text) {
		this.textBox = text;
	}
	
	public DecimalValidator(SuggestBox suggest) {
		this.suggestBox = suggest;
	}	
	
	@Override
	public void invokeActions(ValidationResult result) {
		if(textBox != null) {
			for(ValidationAction<TextBoxBase> va : this.getFailureActions())
				va.invoke(result, textBox);
		}else {
			for(ValidationAction<SuggestBox> va : this.getFailureActions())
				va.invoke(result, suggestBox);
		}
	}

	@Override
	public <V extends ValidationMessages> ValidationResult validate(V messages) {
		
		String text;
		if(suggestBox != null)
			text = suggestBox.getText();
		else text = textBox.getText();
	
		if(text.equals("") && !isRequired())
			return null;
		
		String numberPattern = Main.i18n("general.decimal.pattern");
		// Must be only two section
		String[] number = text.split(numberPattern);
		if (number.length!=2) {
			return new ValidationResult(messages.getStandardMessages().notADouble());
		}
		
		numberPattern = "[0-9]*";
		if(!number[0].matches(numberPattern) || !number[1].matches(numberPattern)) {
			return new ValidationResult(messages.getStandardMessages().notADouble());
		}

		return null;
	}
}