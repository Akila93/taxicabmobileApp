/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

////////////////////////////////////////////////////////////////////////////////
// Implemented changes compared to 2.1, 2.2, 2.3:
// * Change I44e3c0af: Make disabled TextViews uneditable (issue 2771)
////////////////////////////////////////////////////////////////////////////////

package edu.ubbdroid.android.widget;

import edu.ubbdroid.PatchIncluder;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

/*
 * This is supposed to be a *very* thin veneer over TextView.
 * Do not make any changes here that do anything that a TextView
 * with a key listener and a movement method wouldn't do!
 */

/**
 * EditText is a thin veneer over TextView that configures itself to be
 * editable.
 * 
 * <p>
 * See the <a href="{@docRoot}
 * resources/tutorials/views/hello-formstuff.html">Form Stuff tutorial</a>.
 * </p>
 * <p>
 * <b>XML attributes</b>
 * <p>
 * See {@link android.R.styleable#EditText EditText Attributes},
 * {@link android.R.styleable#TextView TextView Attributes},
 * {@link android.R.styleable#View View Attributes}
 */
public class EditText extends android.widget.EditText {
	public EditText(Context context) {
		this(context, null);
	}

	public EditText(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.editTextStyle);
	}

	public EditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void setEnabled(boolean enabled) {
		if (PatchIncluder.includePath("I44e3c0af")) {
			if (enabled == isEnabled()) {
				return;
			}

			if (!enabled) {
				hideSoftInputWindow();
			}
		}
		
		super.setEnabled(enabled);
	}

	private void hideSoftInputWindow() {
		// Hide the soft input if the currently active TextView is disabled
		InputMethodManager imm = (InputMethodManager) getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm != null && imm.isActive(this)) {
			imm.hideSoftInputFromWindow(getWindowToken(), 0);
		}
	}

	@Override
	public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
		if (PatchIncluder.includePath("I44e3c0af")) {
			if (isEnabled()) {
				return super.onCreateInputConnection(outAttrs);
			} else {
				return null;
			}
		}
		
		return super.onCreateInputConnection(outAttrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		boolean onTouch = super.onTouchEvent(event);
		
		if (PatchIncluder.includePath("I44e3c0af") && !isEnabled()) {
			hideSoftInputWindow();
		}
		
		return onTouch;
	}

}
