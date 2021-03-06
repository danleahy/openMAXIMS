// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.rejectionreasondialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		RefMan = new RefManContext(context);
	}
	public final class RefManContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private RefManContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getRejectionReasonIsNotNull()
		{
			return !cx_RefManRejectionReason.getValueIsNull(context);
		}
		public ims.RefMan.vo.RejectReferralVo getRejectionReason()
		{
			return (ims.RefMan.vo.RejectReferralVo)cx_RefManRejectionReason.getValue(context);
		}
		public void setRejectionReason(ims.RefMan.vo.RejectReferralVo value)
		{
			cx_RefManRejectionReason.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManRejectionReason = new ims.framework.ContextVariable("RefMan.RejectionReason", "_cv_RefMan.RejectionReason");
		public boolean getPrintRejectionLettersIsNotNull()
		{
			return !cx_RefManPrintRejectionLetters.getValueIsNull(context);
		}
		public Boolean getPrintRejectionLetters()
		{
			return (Boolean)cx_RefManPrintRejectionLetters.getValue(context);
		}
		public void setPrintRejectionLetters(Boolean value)
		{
			cx_RefManPrintRejectionLetters.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_RefManPrintRejectionLetters = new ims.framework.ContextVariable("RefMan.PrintRejectionLetters", "_cv_RefMan.PrintRejectionLetters");

		private ims.framework.Context context;
	}

	public RefManContext RefMan;
}
