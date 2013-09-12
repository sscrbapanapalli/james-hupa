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
package org.apache.hupa.client.rf;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface HupaRequestFactory extends RequestFactory {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	SubjectRequest subjectRequest();

	ImapFolderRequest folderRequest();

	CheckSessionRequest sessionRequest();

	LoginUserRequest loginRequest();

	LogoutUserRequest logoutRequest();

	FetchFoldersRequest fetchFoldersRequest();

	FetchMessagesRequest messagesRequest();

	MoveMessageRequest moveMessageRequest();

	CreateFolderRequest createFolderRequest();

	DeleteFolderRequest deleteFolderRequest();

	RenameFolderRequest renameFolderRequest();

	DeleteMessageByUidRequest deleteMessageByUidRequest();

	DeleteMessageAllRequest deleteMessageAllRequest();

	GetMessageDetailsRequest messageDetailsRequest();

	SendMessageRequest sendMessageRequest();

	SendForwardMessageRequest sendForwardMessageRequest();

	SendReplyMessageRequest sendReplyMessageRequest();

	IdleRequest idleRequest();

	SetFlagRequest setFlagRequest();
=======
  SubjectRequest subjectRequest();
<<<<<<< HEAD
>>>>>>> first commit
=======
  UserRequest userRequest();
  IMAPFolderRequestContext folderRequest();
>>>>>>> As the FetchFolders RequestFactory, but can not run correctly.
=======
  SubjectRequest subjectRequest();
<<<<<<< HEAD
>>>>>>> first commit
=======
  UserRequest userRequest();
<<<<<<< HEAD
  IMAPFolderRequestContext folderRequest();
>>>>>>> As the FetchFolders RequestFactory, but can not run correctly.
=======
  ImapFolderRequestContext folderRequest();
>>>>>>> Make the ValueProxy(ImapFolder) work with Manolo's patch. Hupa can display folders in west view with RequestFactory now.
=======
	SubjectRequest subjectRequest();
	ImapFolderRequest folderRequest();
	CheckSessionRequest sessionRequest();
	LoginUserRequest loginRequest();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Make chechsession and login work with RF, with refactoring fetch folders.
=======
	FetchMessagesRequest messagesRequest();
<<<<<<< HEAD
>>>>>>> try to fetch messages, yet can not fire the login event in ModelTable such that just get a NullPointerException in it.
=======
=======
	LogoutUserRequest logoutRequest();
	FetchFoldersRequest fetchFoldersRequest();
	FetchMessagesRequest messagesRequest();
	MoveMessageRequest moveMessageRequest();
>>>>>>> other RFs
	CreateFolderRequest createFolderRequest();
<<<<<<< HEAD
>>>>>>> Succeed creating new folder
=======
	DeleteFolderRequest deleteFolderRequest();
	RenameFolderRequest renameFolderRequest();
<<<<<<< HEAD
>>>>>>> delete and rename folder
=======
	DeleteMessageByUidRequest deleteMessageByUidRequest();
	DeleteMessageAllRequest deleteMessageAllRequest();
<<<<<<< HEAD
>>>>>>> delete messages, make WestActivity Singleton
=======
	GetMessageDetailsRequest messageDetailsRequest();
<<<<<<< HEAD
>>>>>>> try to get message details, problem is:
=======
	SendMessageRequest sendMessageRequest();
	SendForwardMessageRequest sendForwardMessageRequest();
	SendReplyMessageRequest sendReplyMessageRequest();
<<<<<<< HEAD
>>>>>>> forward and reply message to use RF
=======
	IdleRequest idleRequest();
	SetFlagRequest setFlagRequest();
>>>>>>> other RFs
}