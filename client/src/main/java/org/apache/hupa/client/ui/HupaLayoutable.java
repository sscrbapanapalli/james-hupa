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

package org.apache.hupa.client.ui;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.apache.hupa.client.place.SettingPlace;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

public interface HupaLayoutable extends Layoutable {
	AcceptsOneWidget getTopBarView();

	AcceptsOneWidget getLogoView();

	AcceptsOneWidget getNavigationView();

	AcceptsOneWidget getToolBarView();

	AcceptsOneWidget getFolderListView();

	AcceptsOneWidget getMessageListView();

	AcceptsOneWidget getMessageListFooterView();

	AcceptsOneWidget getMessageContentView();

	AcceptsOneWidget getStatusView();

	AcceptsOneWidget getComposeToolBarView();

	AcceptsOneWidget getComposeView();

	AcceptsOneWidget getNotificationView();

	AcceptsOneWidget getLabelListView();
	AcceptsOneWidget getContactListView();

	AcceptsOneWidget getLabelPropertiesView();

	void switchTo(int layout);

	AcceptsOneWidget getContactPropertiesView();

	AcceptsOneWidget getContactsListView();

	AcceptsOneWidget getSearchBoxView();

	AcceptsOneWidget getSettingNavView();

	void arrangeSettingLayout(SettingPlace sp);
=======
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public interface HupaLayoutable {
	LayoutPanel get();
<<<<<<< HEAD
>>>>>>> refactoring
=======

	SimplePanel getLoginView();
>>>>>>> make login page as one part of the overall layout & splite layout to little one
=======

public interface HupaLayoutable extends Layoutable{
>>>>>>> integrate them as a whole one - first: make the default place work
=======
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public interface HupaLayoutable extends Layoutable {
	AcceptsOneWidget getTopBarView();

	AcceptsOneWidget getLogoView();

	AcceptsOneWidget getNavigationView();

	AcceptsOneWidget getToolBarView();

	AcceptsOneWidget getFolderListView();

	AcceptsOneWidget getMessageListView();

	AcceptsOneWidget getMessageListFooterView();

	AcceptsOneWidget getMessageContentView();

	AcceptsOneWidget getStatusView();
<<<<<<< HEAD
>>>>>>> integrate all of the views to their corresponding activities and mappers
=======

	void switchToCompose();

	void switchToMessage();
>>>>>>> could change main panel dynamically currently by clicking the compose button
}
