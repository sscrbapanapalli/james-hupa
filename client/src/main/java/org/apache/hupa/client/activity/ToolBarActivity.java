/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.hupa.client.activity;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import org.apache.hupa.client.place.FolderPlace;
import org.apache.hupa.client.rf.SetFlagRequest;
import org.apache.hupa.client.ui.MessagesCellTable;
import org.apache.hupa.client.ui.ToolBarView.Parameters;
import org.apache.hupa.shared.data.MessageImpl.IMAPFlag;
import org.apache.hupa.shared.domain.GenericResult;
import org.apache.hupa.shared.domain.ImapFolder;
import org.apache.hupa.shared.domain.Message;
import org.apache.hupa.shared.domain.SetFlagAction;
import org.apache.hupa.shared.events.RefreshMessagesEvent;
import org.apache.hupa.shared.events.RefreshUnreadEvent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class ToolBarActivity extends AppBaseActivity {

	@Inject private Displayable display;
	@Inject private MessagesCellTable table;
	@Inject private MessageListActivity.Displayable messagesDisplay;
	private String folderName;

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		container.setWidget(display.asWidget());
		bindTo(eventBus);
		if(pc.getWhere() instanceof FolderPlace){
			display.enableAllTools(false);
		}
	}

	public ToolBarActivity with(String folder) {
		this.folderName = folder;
		return this;
	}

	public Displayable getDisplay() {
		return display;
	}

	private void bindTo(final EventBus eventBus) {
		registerHandler(display.getMarkRead().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hc.showTopLoading("Loading");
				toMarkRead(true);
				display.getPopup().hide();
			}
		}));
		registerHandler(display.getMarkUnread().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hc.showTopLoading("Loading");
				toMarkRead(false);
				display.getPopup().hide();
			}
		}));

		registerHandler(display.getRefresh().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hc.showTopLoading("Loading");
				eventBus.fireEvent(new RefreshMessagesEvent());
				eventBus.fireEvent(new RefreshUnreadEvent());
			}
		}));
	}

	protected void toMarkRead(boolean read) {
		List<Long> uids = new ArrayList<Long>();
		for (Message msg : table.getVisibleItems()) {
			if (table.getSelectionModel().isSelected(msg)) {
				uids.add(msg.getUid());
				table.markRead(msg, read);
			}
		}
		SetFlagRequest req = this.rf.setFlagRequest();
		SetFlagAction action = req.create(SetFlagAction.class);
		ImapFolder f = req.create(ImapFolder.class);
		f.setFullName(folderName);
		action.setFolder(f);
		action.setFlag(IMAPFlag.SEEN);
		action.setValue(read);
		action.setUids(uids);
		req.set(action).fire(new Receiver<GenericResult>() {
			@Override
			public void onSuccess(GenericResult response) {
				eventBus.fireEvent(new RefreshUnreadEvent());
				messagesDisplay.refresh();
				hc.hideTopLoading();
			}
		});
	}


	// FIXME: for some reason if we extend WidgetDisplayable we get the error
	// ToolBarActivity.java:[124,38] error: cannot find symbol
	public interface Displayable /*extends WidgetDisplayable*/ {
	    // FIXME: added this method until we fix the problem with inheritance
	    com.google.gwt.user.client.ui.Widget asWidget();

		void enableSendingTools(boolean is);
		void enableDealingTools(boolean is);
		void enableAllTools(boolean is);

		HasClickHandlers getRefresh();
		HasClickHandlers getReply();
		HasClickHandlers getReplyAll();
		HasClickHandlers getForward();
		void setParameters(Parameters parameters);
		Parameters getParameters();
		HasClickHandlers getMarkUnread();
		HasClickHandlers getMarkRead();
		HasClickHandlers getMark();
		HasClickHandlers getDelete();
		PopupPanel getPopup();
		HasClickHandlers getCompose();
	}
=======
=======
=======
=======
import java.util.ArrayList;
import java.util.List;

import org.apache.hupa.client.rf.SetFlagRequest;
>>>>>>> try to link the mark actions to rf services
import org.apache.hupa.client.ui.MessagesCellTable;
>>>>>>> link the mark action to the message list such that they can change upon the actions
import org.apache.hupa.client.ui.ToolBarView.Parameters;
>>>>>>> coping with reply and forward sending message
import org.apache.hupa.client.ui.WidgetDisplayable;
import org.apache.hupa.shared.data.MessageImpl.IMAPFlag;
import org.apache.hupa.shared.domain.GenericResult;
import org.apache.hupa.shared.domain.ImapFolder;
import org.apache.hupa.shared.domain.Message;
import org.apache.hupa.shared.domain.SetFlagAction;
import org.apache.hupa.shared.events.LoadMessagesEvent;
import org.apache.hupa.shared.events.LoadMessagesEventHandler;
import org.apache.hupa.shared.events.LoginEvent;
import org.apache.hupa.shared.events.LoginEventHandler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class ToolBarActivity extends AppBaseActivity {

	@Inject private Displayable display;
	@Inject private MessagesCellTable table;
	private String folderName;

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		container.setWidget(display.asWidget());
		bindTo(eventBus);
	}

	public ToolBarActivity with(String folder) {
		this.folderName = folder;
		return this;
	}

<<<<<<< HEAD
	@Inject private Displayable display;
	
	public interface Displayable extends WidgetDisplayable {}
>>>>>>> integrate all of the views to their corresponding activities and mappers
=======
	private void bindTo(EventBus eventBus) {
		eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
			@Override
			public void onLogin(LoginEvent e) {
				display.setParameters(new Parameters(e.getUser(), null, null, null));
			}
		});
		eventBus.addHandler(LoadMessagesEvent.TYPE, new LoadMessagesEventHandler() {
			public void onLoadMessagesEvent(LoadMessagesEvent loadMessagesEvent) {
				display.enableAllTools(false);
			}
		});
		registerHandler(display.getMark().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// Reposition the popup relative to the button
				Widget source = (Widget) event.getSource();
				int left = source.getAbsoluteLeft();
				int top = source.getAbsoluteTop() + source.getOffsetHeight();
				display.getPopup().setPopupPosition(left, top);
				// Show the popup
				display.getPopup().show();
			}
		}));
		registerHandler(display.getMarkRead().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				toMarkRead(true);
				display.getPopup().hide();
			}
		}));
		registerHandler(display.getMarkUnread().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				toMarkRead(false);
				display.getPopup().hide();
			}
		}));
	}

	protected void toMarkRead(boolean read) {
		List<Long> uids = new ArrayList<Long>();
		for (Message msg : table.getVisibleItems()) {
			if (table.getSelectionModel().isSelected(msg)) {
				uids.add(msg.getUid());
				table.markRead(msg, read);
			}
		}
		SetFlagRequest req = this.requestFactory.setFlagRequest();
		SetFlagAction action = req.create(SetFlagAction.class);
		ImapFolder f = req.create(ImapFolder.class);
		f.setFullName(folderName);
		action.setFolder(f);
		action.setFlag(IMAPFlag.SEEN);
		action.setValue(read);
		action.setUids(uids);
		req.set(action).fire(new Receiver<GenericResult>() {
			@Override
			public void onSuccess(GenericResult response) {
				table.refresh();
			}
		});
	}

	public interface Displayable extends WidgetDisplayable {

		void enableSendingTools(boolean is);
		void enableDealingTools(boolean is);
		void enableAllTools(boolean is);

		HasClickHandlers getReply();

		HasClickHandlers getReplyAll();

		HasClickHandlers getForward();

		void setParameters(Parameters parameters);

		HasClickHandlers getMarkUnread();

		HasClickHandlers getMarkRead();

		HasClickHandlers getMark();

		PopupPanel getPopup();
	}
>>>>>>> add enable tool bar buttons toggling event, with being related to issue #31
}
