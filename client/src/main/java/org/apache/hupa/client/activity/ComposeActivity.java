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
=======
>>>>>>> make attachments sending work as expected
import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.OnCancelUploaderHandler;
import gwtupload.client.IUploader.OnFinishUploaderHandler;
import gwtupload.client.IUploader.OnStatusChangedHandler;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hupa.client.HupaController;
import org.apache.hupa.client.place.ComposePlace;
import org.apache.hupa.client.rf.SendForwardMessageRequest;
import org.apache.hupa.client.rf.SendMessageRequest;
import org.apache.hupa.client.rf.SendReplyMessageRequest;
import org.apache.hupa.client.ui.MessagesCellTable;
import org.apache.hupa.client.validation.EmailListValidator;
import org.apache.hupa.shared.Util;
import org.apache.hupa.shared.data.MessageAttachmentImpl;
import org.apache.hupa.shared.domain.GenericResult;
import org.apache.hupa.shared.domain.ImapFolder;
import org.apache.hupa.shared.domain.Message;
import org.apache.hupa.shared.domain.MessageAttachment;
import org.apache.hupa.shared.domain.MessageDetails;
import org.apache.hupa.shared.domain.SendForwardMessageAction;
import org.apache.hupa.shared.domain.SendMessageAction;
import org.apache.hupa.shared.domain.SendReplyMessageAction;
import org.apache.hupa.shared.domain.SmtpMessage;
import org.apache.hupa.shared.domain.User;
import org.apache.hupa.shared.events.LoginEvent;
import org.apache.hupa.shared.events.LoginEventHandler;
import org.apache.hupa.shared.events.MailToEvent;
import org.apache.hupa.shared.events.MailToEventHandler;

import com.google.gwt.activity.shared.Activity;
=======
=======
>>>>>>> make attachments sending work as expected
import java.util.ArrayList;
import java.util.List;

import org.apache.hupa.client.place.ComposePlace;
import org.apache.hupa.client.rf.SendForwardMessageRequest;
import org.apache.hupa.client.rf.SendMessageRequest;
import org.apache.hupa.client.rf.SendReplyMessageRequest;
import org.apache.hupa.client.ui.WidgetDisplayable;
import org.apache.hupa.client.validation.EmailListValidator;
import org.apache.hupa.shared.data.MessageAttachmentImpl;
import org.apache.hupa.shared.domain.GenericResult;
import org.apache.hupa.shared.domain.ImapFolder;
import org.apache.hupa.shared.domain.MessageAttachment;
import org.apache.hupa.shared.domain.SendForwardMessageAction;
import org.apache.hupa.shared.domain.SendMessageAction;
import org.apache.hupa.shared.domain.SendReplyMessageAction;
import org.apache.hupa.shared.domain.SmtpMessage;
import org.apache.hupa.shared.domain.User;
import org.apache.hupa.shared.events.LoginEvent;
import org.apache.hupa.shared.events.LoginEventHandler;

<<<<<<< HEAD
>>>>>>> make send text mail work excellently
=======
import com.google.gwt.activity.shared.Activity;
>>>>>>> coping with reply and forward sending message
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
<<<<<<< HEAD
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ListBox;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class ComposeActivity extends AppBaseActivity {
	@Inject private Displayable display;
	@Inject private HupaController hupaController;
	@Inject private TopBarActivity topBar;
	private List<MessageAttachment> attachments = new ArrayList<MessageAttachment>();
	private ComposePlace place;
	private User user;

	public Activity with(ComposePlace place) {
		this.place = place;
		return this;
	}
=======
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class ComposeActivity extends AppBaseActivity {
	@Inject private Displayable display;
	private List<MessageAttachment> attachments = new ArrayList<MessageAttachment>();
<<<<<<< HEAD
	private Type type = Type.NEW;
<<<<<<< HEAD
>>>>>>> make send text mail work excellently
=======
	private User user;
>>>>>>> add user label, yet issue46 occur
=======
	private User user;
	private ComposePlace place;
>>>>>>> coping with reply and forward sending message

	public Activity with(ComposePlace place) {
		this.place = place;
		return this;
	}

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		container.setWidget(display.asWidget());
<<<<<<< HEAD
<<<<<<< HEAD
		bindTo(eventBus);
		fillHeader();
	}

	@Override
	public String mayStop() {
		super.mayStop();
		if (noContent()) {
			return null;
		}
		return null;
//		return "Do you want to leave this page?"; TODO
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	private boolean noContent() {
		return "".equals(display.getMessage().getText()) && "".equals(display.getSubject().getText());
	}

	@Override
	public void onCancel() {

	}

	private void fillHeader() {
		if (place == null || place.getParameters() == null)
			return;
		if (user == null){
			user = place.getParameters().getUser();
		}
		if(user == null){
			user = topBar.getUser();
		}
		display.getFromList().addItem(user.getName());
		if("new".equals(place.getToken())){
			return;
		}
		Message oldMessage = place.getParameters().getOldmessage();
		display.getMessageHTML().setHTML(
				wrapMessage(oldMessage, place.getParameters().getOldDetails(), place.getToken()));
		if ("forward".equals(place.getToken())) {
			String subject = oldMessage.getSubject() != null ? oldMessage.getSubject().trim() : "";
			if (!subject.toLowerCase().startsWith("fwd:")) {
				subject = "Fwd: " + subject;
			}
			display.getSubject().setText(subject);
		} else if ("reply".equals(place.getToken()) || "replyAll".equals(place.getToken())) {

			String subject = oldMessage.getSubject() != null ? oldMessage.getSubject().trim() : "";
			if (!subject.toLowerCase().startsWith("re:")) {
				subject = "Re: " + subject;
			}
			if ("reply".equals(place.getToken())) {
				display.getSubject().setText(subject);
				if (oldMessage.getReplyto() != null && !oldMessage.getFrom().contains(oldMessage.getReplyto())) {
					display.getTo().setText(oldMessage.getReplyto());
				} else {
					display.getTo().setText(oldMessage.getFrom());
				}
			} else if ("replyAll".equals(place.getToken())) {
				ArrayList<String> list = new ArrayList<String>();
				if (oldMessage.getReplyto() != null && !oldMessage.getFrom().contains(oldMessage.getReplyto()))
					list.add(oldMessage.getReplyto());
				if (oldMessage.getTo() != null)
					list.addAll(oldMessage.getTo());
				if (oldMessage.getCc() != null)
					list.addAll(oldMessage.getCc());
				list = removeEmailFromList(list, user.getName());
				display.getCc().setText(Util.listToString(list));
				if (oldMessage.getTo() != null) {
					oldMessage.getTo().remove(user.getName());
				}
				display.getTo().setText(oldMessage.getFrom());
			}
		}
	}

	protected ArrayList<String> removeEmailFromList(List<String> list, String email) {
		ArrayList<String> ret = new ArrayList<String>();
		String regex = ".*<?\\s*" + email.trim() + "\\s*>?\\s*";
		for (String e : list) {
			if (!e.matches(regex)) {
				ret.add(e);
			}
		}
		return ret;
	}
	private static String generateHeader(Message message, String type) {
		String ret = "<br>";
		if (message != null) {
			if (type.equals("forward")) {
				ret += "--------- Forwarded message --------- <br>";
				ret += "From: " + message.getFrom().replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "<br>";
				ret += "Date: " + message.getReceivedDate() + "<br>";
				ret += "Subject: " + message.getSubject() + "<br>";
				ArrayList<String> to = new ArrayList<String>();
				to.addAll(message.getTo());
				to.addAll(message.getCc());
				ret += "To: " + Util.listToString(to).replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "<br>";
			} else if (type.equals("reply") || type.equals("replyAll")) {
				ret += "On " + message.getReceivedDate();
				ret += ", " + message.getFrom().replaceAll("<", "&lt;").replaceAll(">", "&gt;");
				ret += ". wrote:<br>";
			}
		}
		return ret + "<br>";
	}
	public static String wrapMessage(Message message, MessageDetails details, String type) {
		String ret = "";
		if (message != null) {
			ret += generateHeader(message, type);
		}
		if (details != null && details.getText() != null && details.getText().length() > 0) {
			ret += "<blockquote style='border-left: 1px solid rgb(204, 204, 204); margin: 0pt 0pt 0pt 0.8ex; padding-left: 1ex;'>";
			ret += details.getText();
			ret += "</blockquote>";
		}
		return ret;
	}
	private void bindTo(EventBus eventBus) {
		eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
			public void onLogin(LoginEvent event) {
				user = event.getUser();
			}
		});
		registerHandler(display.getSendClick().addClickHandler(sendClickHandler));
		registerHandler(display.getCancelClick().addClickHandler(cancelClickHandler));

		registerHandler(display.getCcClick().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				display.showCc();
			}
		}));
		registerHandler(display.get_CcClick().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				display.hideCc();
			}
		}));
		registerHandler(display.getBccClick().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				display.showBcc();
			}
		}));
		registerHandler(display.get_BccClick().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				display.hideBcc();
			}
		}));
		registerHandler(display.getReplyClick().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				display.showReply();
			}
		}));
		registerHandler(display.get_ReplyClick().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				display.hideReply();
			}
		}));
		registerHandler(display.getFollowupClick().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				display.showFollowup();
			}
		}));
		registerHandler(display.get_FollowupClick().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				display.hideFollowup();
			}
		}));
		registerHandler(display.getUploader().addOnStatusChangedHandler(onStatusChangedHandler));
		registerHandler(display.getUploader().addOnFinishUploadHandler(onFinishUploadHandler));
		registerHandler(display.getUploader().addOnCancelUploadHandler(onCancelUploadHandler));

		eventBus.addHandler(MailToEvent.TYPE, new MailToEventHandler(){

			@Override
			public void onMailTo(MailToEvent event) {
				display.getTo().setText(event.getMailto());
			}});
		
		fillSuggestList();
		
	}

	private void fillSuggestList() {
		Storage contactStore = Storage.getLocalStorageIfSupported();
		if(contactStore != null){
			String contactsString = contactStore.getItem(MessagesCellTable.CONTACTS_STORE);
			if(contactsString != null){
				display.fillContactList(contactsString.replace("[", "").replace("]", "").trim().split(","));	
			}	
		}
	}

	private OnFinishUploaderHandler onFinishUploadHandler = new OnFinishUploaderHandler() {
		public void onFinish(IUploader uploader) {
			if (uploader.getStatus() == Status.SUCCESS) {
				String name = uploader.getInputName();
				MessageAttachment attachment = new MessageAttachmentImpl();
				attachment.setName(name);
				attachments.add(attachment);
			}
		}
	};

	private OnStatusChangedHandler onStatusChangedHandler = new OnStatusChangedHandler() {
		public void onStatusChanged(IUploader uploader) {
			// TODO buttons disabled
			// Status stat = display.getUploader().getStatus();

			// if (stat == Status.INPROGRESS)
			// display.getSendEnable().setEnabled(false);
			// else
			// display.getSendEnable().setEnabled(true);
		}
	};

	private OnCancelUploaderHandler onCancelUploadHandler = new OnCancelUploaderHandler() {
		public void onCancel(IUploader uploader) {
			for (Iterator<MessageAttachment> i = attachments.iterator(); i.hasNext();) {
				MessageAttachment attachment = i.next();
				if (attachment.getName().equals(uploader.getInputName()))
					i.remove();
			}
		}
	};

	private ClickHandler cancelClickHandler = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			History.back();
		}

	};

=======

=======
>>>>>>> add user label, yet issue46 occur
		bindTo(eventBus);

		display.getFromList().addItem("demo");
		if (user != null) {// FIXME
			display.getFromList().addItem(user.getName());
		}
	}

	private void bindTo(EventBus eventBus) {
		eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
			public void onLogin(LoginEvent event) {
				user = event.getUser();
			}
		});
		registerHandler(display.getSendClick().addClickHandler(sendClickHandler));
		display.getUploader().addOnStatusChangedHandler(onStatusChangedHandler);
		display.getUploader().addOnFinishUploadHandler(onFinishUploadHandler);
		display.getUploader().addOnCancelUploadHandler(onCancelUploadHandler);
	}

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> make send text mail work excellently
=======
    private OnFinishUploaderHandler onFinishUploadHandler = new OnFinishUploaderHandler() {
        public void onFinish(IUploader uploader) {
            if (uploader.getStatus() == Status.SUCCESS) {
                String name = uploader.getInputName();
                MessageAttachment attachment = new MessageAttachmentImpl();
                attachment.setName(name);
                attachments.add(attachment);
            }
        }
    };

    private OnStatusChangedHandler onStatusChangedHandler = new OnStatusChangedHandler() {
        public void onStatusChanged(IUploader uploader) {
            Status stat = display.getUploader().getStatus();
        }
    };

    private OnCancelUploaderHandler onCancelUploadHandler = new OnCancelUploaderHandler() {
        public void onCancel(IUploader uploader) {
            for (MessageAttachment attachment : attachments) {
                if (attachment.getName().equals(uploader.getInputName()))
                    attachments.remove(attachment);
            }
        }
    };
>>>>>>> make attachments sending work as expected
=======
	private OnFinishUploaderHandler onFinishUploadHandler = new OnFinishUploaderHandler() {
		public void onFinish(IUploader uploader) {
			if (uploader.getStatus() == Status.SUCCESS) {
				String name = uploader.getInputName();
				MessageAttachment attachment = new MessageAttachmentImpl();
				attachment.setName(name);
				attachments.add(attachment);
			}
		}
	};

	private OnStatusChangedHandler onStatusChangedHandler = new OnStatusChangedHandler() {
		public void onStatusChanged(IUploader uploader) {
			// Status stat = display.getUploader().getStatus(); //TODO buttons
			// disabled
		}
	};

	private OnCancelUploaderHandler onCancelUploadHandler = new OnCancelUploaderHandler() {
		public void onCancel(IUploader uploader) {
			for (MessageAttachment attachment : attachments) {
				if (attachment.getName().equals(uploader.getInputName()))
					attachments.remove(attachment);
			}
		}
	};

>>>>>>> coping with reply and forward sending message
	protected ClickHandler sendClickHandler = new ClickHandler() {
		public void onClick(ClickEvent event) {
			if (!validate())
				return;
<<<<<<< HEAD
<<<<<<< HEAD
			hupaController.showTopLoading("Sending...");

			if ("new".equals(place.getToken())) {
				SendMessageRequest sendReq = rf.sendMessageRequest();
				SendMessageAction sendAction = sendReq.create(SendMessageAction.class);
				sendAction.setMessage(parseMessage(sendReq));
=======
			sendReq = requestFactory.sendMessageRequest();
			message = sendReq.create(SmtpMessage.class);
			List<MessageAttachment> attaches = new ArrayList<MessageAttachment>();
			for (MessageAttachment attach : attachments) {
				MessageAttachment attachMent = sendReq.create(MessageAttachment.class);
				attachMent.setName(attach.getName());
				attachMent.setSize(attach.getSize());
				attachMent.setContentType(attach.getContentType());
				attaches.add(attachMent);
			}
			message.setFrom(display.getFromText());
			message.setSubject(display.getSubjectText().getText());
			message.setText(display.getMessageHTML().getHTML());
			message.setMessageAttachments(attaches);
			message.setTo(emailTextToArray(display.getToText().getText()));
			message.setCc(emailTextToArray(display.getCcText().getText()));
			message.setBcc(emailTextToArray(display.getBccText().getText()));
=======
>>>>>>> coping with java.lang.IllegalArgumentException: uid

			if ("new".equals(place.getToken())) {
				SendMessageRequest sendReq = requestFactory.sendMessageRequest();
				SendMessageAction sendAction = sendReq.create(SendMessageAction.class);
<<<<<<< HEAD
<<<<<<< HEAD
				// SmtpMessage sm = sendReq.edit(message);
				sendAction.setMessage(message);
>>>>>>> make send text mail work excellently
=======
				SmtpMessage sm = sendReq.edit(message);
				sendAction.setMessage(sm);
>>>>>>> coping with reply and forward sending message
=======
				sendAction.setMessage(parseMessage(sendReq));
>>>>>>> coping with java.lang.IllegalArgumentException: uid
				sendReq.send(sendAction).fire(new Receiver<GenericResult>() {
					@Override
					public void onSuccess(GenericResult response) {
						afterSend(response);
					}
				});
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
			} else if ("forward".equals(place.getToken())) {
				// FIXME will get a NullPointerException given accessing
				// directly from some URL like #/compose:forward
<<<<<<< HEAD
				SendForwardMessageRequest req = rf.sendForwardMessageRequest();
				SendForwardMessageAction action = req.create(SendForwardMessageAction.class);
				action.setMessage(parseMessage(req));
				ImapFolder f = req.create(ImapFolder.class);
				f.setFullName(place.getParameters().getFolderName());
				action.setFolder(f);
				action.setUid(place.getParameters().getOldmessage().getUid());
				req.send(action).fire(new Receiver<GenericResult>() {
=======
				System.out.println("new: " + place.getParameters().getOldmessage().getUid());
			} else if ("reply".equals(place.getToken())) {
=======
			} else if ("forward".equals(place.getToken())) {
<<<<<<< HEAD
				System.out.println("reply: " + place.getParameters().getOldmessage().getUid());
>>>>>>> coping with java.lang.IllegalArgumentException: uid
				SendForwardMessageRequest forwardReq = requestFactory.sendForwardMessageRequest();
				SendForwardMessageAction forwardAction = forwardReq.create(SendForwardMessageAction.class);
				forwardAction.setMessage(parseMessage(forwardReq));
				ImapFolder folder = forwardReq.create(ImapFolder.class);
				folder.setFullName(place.getParameters().getFolder().getFullName());
				forwardAction.setFolder(folder);
				forwardAction.setUid(place.getParameters().getOldmessage().getUid());
				forwardReq.send(forwardAction).fire(new Receiver<GenericResult>() {
>>>>>>> coping with reply and forward sending message
=======
				//FIXME will get a NullPointerException given accessing directly from some URL like #/compose:forward
=======
>>>>>>> scrub code
				SendForwardMessageRequest req = requestFactory.sendForwardMessageRequest();
				SendForwardMessageAction action = req.create(SendForwardMessageAction.class);
				action.setMessage(parseMessage(req));
				ImapFolder f = req.create(ImapFolder.class);
				f.setFullName(place.getParameters().getFolder().getFullName());
				action.setFolder(f);
				action.setUid(place.getParameters().getOldmessage().getUid());
				req.send(action).fire(new Receiver<GenericResult>() {
>>>>>>> fixed the requestfactory's quirk
					@Override
					public void onSuccess(GenericResult response) {
						afterSend(response);
					}
				});
<<<<<<< HEAD
<<<<<<< HEAD
			} else {
				SendReplyMessageRequest replyReq = rf.sendReplyMessageRequest();
				SendReplyMessageAction action = replyReq.create(SendReplyMessageAction.class);
				action.setMessage(parseMessage(replyReq));
				ImapFolder folder = replyReq.create(ImapFolder.class);
				folder.setFullName(place.getParameters().getFolderName());
				action.setFolder(folder);
				action.setUid(place.getParameters().getOldmessage().getUid());
				replyReq.send(action).fire(new Receiver<GenericResult>() {
					@Override
					public void onSuccess(GenericResult response) {
						afterSend(response);
					}
				});
=======
			} else if (type == Type.FORWARD) {
				// SendForwardMessageRequest forwardReq =
				// requestFactory.sendForwardMessageRequest();
				// SendForwardMessageAction forwardAction =
				// forwardReq.create(SendForwardMessageAction.class);
				// forwardAction.setMessage(message);
				// forwardAction.setFolder(folder);
				// forwardAction.setUid(oldmessage.getUid());
				// forwardReq.send(forwardAction).fire(new
				// Receiver<GenericResult>() {
				// @Override
				// public void onSuccess(GenericResult response) {
				// afterSend(response);
				// }
				// });
			} else {
				// SendReplyMessageRequest replyReq =
				// requestFactory.sendReplyMessageRequest();
				// SendReplyMessageAction replyAction =
				// replyReq.create(SendReplyMessageAction.class);
				// replyAction.setMessage(message);
				// replyAction.setFolder(folder);
				// replyAction.setUid(oldmessage.getUid());
				// replyReq.send(replyAction).fire(new
				// Receiver<GenericResult>() {
				// @Override
				// public void onSuccess(GenericResult response) {
				// afterSend(response);
				// }
				// });
>>>>>>> make send text mail work excellently
=======
				System.out.println("reply: " + place.getParameters().getOldmessage().getUid());
=======
>>>>>>> coping with java.lang.IllegalArgumentException: uid
			} else {
				SendReplyMessageRequest replyReq = requestFactory.sendReplyMessageRequest();
				SendReplyMessageAction action = replyReq.create(SendReplyMessageAction.class);
				action.setMessage(parseMessage(replyReq));
				ImapFolder folder = replyReq.create(ImapFolder.class);
				folder.setFullName(place.getParameters().getFolder().getFullName());
				action.setFolder(folder);
				action.setUid(place.getParameters().getOldmessage().getUid());
				replyReq.send(action).fire(new Receiver<GenericResult>() {
					@Override
					public void onSuccess(GenericResult response) {
						afterSend(response);
					}
				});
<<<<<<< HEAD
				System.out.println("other forward: " + place.getParameters().getOldmessage().getUid());
>>>>>>> coping with reply and forward sending message
=======
>>>>>>> coping with java.lang.IllegalArgumentException: uid
			}
		}
	};

	private boolean validate() {
		// Don't trust only in view validation
<<<<<<< HEAD
		return display.validate() && display.getTo().getText().trim().length() > 0
				&& EmailListValidator.isValidAddressList(display.getTo().getText())
				&& EmailListValidator.isValidAddressList(display.getCc().getText())
				&& EmailListValidator.isValidAddressList(display.getBcc().getText());
	}

	private SmtpMessage parseMessage(RequestContext rc) {
		SmtpMessage message = rc.create(SmtpMessage.class);
		List<MessageAttachment> attaches = new ArrayList<MessageAttachment>();
		for (MessageAttachment attach : attachments) {
			MessageAttachment attachMent = rc.create(MessageAttachment.class);
			attachMent.setName(attach.getName());
			attachMent.setSize(attach.getSize());
			attachMent.setContentType(attach.getContentType());
			attaches.add(attachMent);
		}
		message.setFrom(display.getFromText());
		message.setSubject(display.getSubject().getText());
		message.setText(display.getMessageHTML().getHTML());
		message.setMessageAttachments(attaches);
		message.setTo(emailTextToArray(display.getTo().getText()));
		message.setCc(emailTextToArray(display.getCc().getText()));
		message.setBcc(emailTextToArray(display.getBcc().getText()));
		return message;
=======
		return display.validate() && display.getToText().getText().trim().length() > 0
				&& EmailListValidator.isValidAddressList(display.getToText().getText())
				&& EmailListValidator.isValidAddressList(display.getCcText().getText())
				&& EmailListValidator.isValidAddressList(display.getBccText().getText());
>>>>>>> make send text mail work excellently
	}

	private SmtpMessage parseMessage(RequestContext rc) {
		SmtpMessage message = rc.create(SmtpMessage.class);
		List<MessageAttachment> attaches = new ArrayList<MessageAttachment>();
		for (MessageAttachment attach : attachments) {
			MessageAttachment attachMent = rc.create(MessageAttachment.class);
			attachMent.setName(attach.getName());
			attachMent.setSize(attach.getSize());
			attachMent.setContentType(attach.getContentType());
			attaches.add(attachMent);
		}
		message.setFrom(display.getFromText());
		message.setSubject(display.getSubjectText().getText());
		message.setText(display.getMessageHTML().getHTML());
		message.setMessageAttachments(attaches);
		message.setTo(emailTextToArray(display.getToText().getText()));
		message.setCc(emailTextToArray(display.getCcText().getText()));
		message.setBcc(emailTextToArray(display.getBccText().getText()));
		return message;
	}

	private List<String> emailTextToArray(String emails) {
		List<String> cc = new ArrayList<String>();
		for (String ccRaw : emails.split("[,;]+")) {
			String ccRecip = ccRaw.trim();
			if (ccRecip.length() > 0) {
				cc.add(ccRaw.trim());
			}
		}
		return cc;
	}

	private void afterSend(GenericResult response) {
<<<<<<< HEAD
		hupaController.hideTopLoading();
		hupaController.showNotice("Your mail has been sent.", 10000);
		History.back();
	}

	public interface Displayable extends IsWidget {
		String getFromText();
		void showCc();
		void hideCc();
		void showBcc();
		void hideBcc();
		void showReply();
		void hideReply();
		void showFollowup();
		void hideFollowup();
		HasText getTo();
		HasText getCc();
		HasText getBcc();
		HasText getSubject();
		HasClickHandlers getSendClick();
		HasClickHandlers getCancelClick();
		HasClickHandlers getCcClick();
		HasClickHandlers get_CcClick();
		HasClickHandlers getBccClick();
		HasClickHandlers get_BccClick();
		HasClickHandlers getReplyClick();
		HasClickHandlers get_ReplyClick();
		HasClickHandlers getFollowupClick();
		HasClickHandlers get_FollowupClick();
		boolean validate();
		HasText getMessage();
		HasHTML getMessageHTML();
		ListBox getFromList();
		IUploader getUploader();
		void fillContactList(String[] contacts);
=======
		Window.alert("//TODO send result is: " + response.isSuccess());
	}

	public interface Displayable extends WidgetDisplayable {
		String getFromText();

		HasText getToText();

		HasText getCcText();

		HasText getBccText();

		HasText getSubjectText();

		HasClickHandlers getSendClick();

		boolean validate();

		HasText getMessageText();

		HasHTML getMessageHTML();
<<<<<<< HEAD
>>>>>>> make send text mail work excellently
=======

		ListBox getFromList();
<<<<<<< HEAD
>>>>>>> add user label, yet issue46 occur
=======

		IUploader getUploader();
>>>>>>> make attachments sending work as expected
	}
}
