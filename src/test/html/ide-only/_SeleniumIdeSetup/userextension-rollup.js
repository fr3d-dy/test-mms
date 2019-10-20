var manager = new RollupManager();
 
//login
manager.addRollupRule({
 name: 'login'
 , description: 'login from login page'
 , args: [{ name: 'username' , description: 'password' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: 'id=loginId', value: ''});
commands.push({ command: 'type', target: 'id=loginId', value: args.username});
commands.push({ command: 'type', target: 'id=loginPassword', value: 'passwd'});
commands.push({ command: 'click', target: 'id=loginButton', value: ''});
commands.push({ command: 'waitForElementPresent', target: 'id=sidebarHeaderDropdownButton', value: ''});
return commands;
 }
});

//logout
manager.addRollupRule({
 name: 'logout'
 , description: 'logout from the user side'
 , args: [], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "//span[@class='sidebar-header-dropdown__icon']", value: ''});
commands.push({ command: 'click', target: "//span[@class='sidebar-header-dropdown__icon']", value: ''}); 
commands.push({ command: 'waitForElementPresent', target: 'css=#logout > button.style--none', value: ''});
commands.push({ command: 'click', target: 'css=#logout > button.style--none', value: ''});
commands.push({ command: 'waitForElementPresent', target: 'id=loginId', value: ''});
return commands;
 }
});

//open channel in sidebar
manager.addRollupRule({
 name: 'openChannel'
 , description: 'Open a channel that is visble in the sidebar'
 , args: [{ name: 'ChannelName', description: 'Only ChannelName is needed'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "//span[@class='sidebar-item__name']/span[contains(text(),'"+args.ChannelName+"')]", value: ''});
commands.push({ command: 'click', target: "//span[@class='sidebar-item__name']/span[contains(text(),'"+args.ChannelName+"')]", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//strong[@id='channelHeaderTitle']/span[contains(text(),'"+args.ChannelName+"')]", value: ''});
return commands;
 }
});

//Create Public Channel
manager.addRollupRule({
 name: 'createPublicChannel'
 , description: 'Creates a public Channel'
 , args: [{ name: 'ChannelName' , description: 'Header' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForText', target: 'link=Town Square', value: 'Town Square'});
commands.push({ command: 'waitForElementPresent', target: 'id=sidebarChannelsMore', value: ''});
commands.push({ command: 'click', target: 'id=sidebarChannelsMore', value: ''});
commands.push({ command: 'waitForText', target: 'id=createNewChannel', value: 'Create New Channel'});
commands.push({ command: 'waitForElementPresent', target: 'id=createNewChannel', value: ''});
commands.push({ command: 'click', target: 'id=createNewChannel', value: ''});
commands.push({ command: 'waitForElementPresent', target: 'css=div.col-sm-9 > input.form-control', value: ''});
commands.push({ command: 'type', target: 'css=div.col-sm-9 > input.form-control', value: ''});
commands.push({ command: 'type', target: 'css=div.col-sm-9 > input.form-control', value: args.ChannelName});
commands.push({ command: 'waitForElementPresent', target: "//button[@type='submit']", value: ''});
commands.push({ command: 'click', target: "//button[@type='submit']", value: ''});
commands.push({ command: 'waitForText', target: 'id=channelHeaderDropdownButton', value: args.ChannelName});
return commands;
 }
});

//Create Private Channel
manager.addRollupRule({
 name: 'createPrivateChannel'
 , description: 'Creates a public Channel'
 , args: [{ name: 'ChannelName' , description: 'Header' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForText', target: 'link=Town Square', value: 'Town Square'});
commands.push({ command: 'waitForElementPresent', target: 'id=createPrivateChannel', value: ''});
commands.push({ command: 'click', target: 'id=createPrivateChannel', value: ''});
commands.push({ command: 'waitForElementPresent', target: 'id=newChannelName', value: ''});
commands.push({ command: 'type', target: 'id=newChannelName', value: args.ChannelName});
commands.push({ command: 'waitForElementPresent', target: "//button[@type='submit']", value: ''});
commands.push({ command: 'click', target: "//button[@type='submit']", value: ''});
commands.push({ command: 'waitForText', target: 'id=channelHeaderDropdownButton', value: args.ChannelName});
return commands;
 }
});


//Add user to channel
manager.addRollupRule({
 name: 'addUserToChannel'
 , description: 'Adds one user to the channel that is currently open'
 , args: [{ name: 'username' , description: 'name of the user to add' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: 'id=channelHeaderTitle', value: ''});
commands.push({ command: 'click', target: 'id=channelHeaderDropdownButton', value: ''});
commands.push({ command: 'waitForElementPresent', target: '//ul[@id="channelHeaderDropdownMenu"]/li/button[text() = "Add Members"]', value: ''});
commands.push({ command: 'click', target: '//ul[@id="channelHeaderDropdownMenu"]/li/button[text() = "Add Members"]', value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]", value: ''});
commands.push({ command: 'click', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]", value: ''});
commands.push({ command: 'waitForElementPresent', target: 'id=saveItems', value: ''});
commands.push({ command: 'click', target: 'id=saveItems', value: ''});
commands.push({ command: 'waitForElementPresent', target: "//span[@data-mention='"+args.username+"']/following-sibling::strong[contains(text(),'added to the channel')]", value: ''});
//^^This fails sometimes when last user is listed in 'other users' - have to click 'others'
return commands;
 }
});

//StoreAndTrimLastPostID
manager.addRollupRule({
 name: 'storeIdForLastPost'
 , description: 'Gets the full post ID of last post and then trims off post_ prefix using main input box. Then stores post ID only to PostVar. (Only works if input box is empty)'
 , args: [{ name: 'PostVar' , description: '' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'storeAttribute', target: "//div[@id='postListContent']//*/div[contains(@style,'position: relative;')][last()]/*//div[contains(@id,'post_')]@id", value: 'LastPostIdFull'});
commands.push({ command: 'assertText', target: "id=post_textbox", value: ''});
commands.push({ command: 'sendKeys', target: "id=post_textbox", value: '${LastPostIdFull}'});
commands.push({ command: 'sendKeys', target: "id=post_textbox", value: '${KEY_HOME}'});
commands.push({ command: 'sendKeys', target: "id=post_textbox", value: '${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}'});
commands.push({ command: 'storeText', target: "//textarea[@id='post_textbox']", value: args.PostVar});
commands.push({ command: 'pause', target: "", value: '1000'});
commands.push({ command: 'sendKeys', target: "id=post_textbox", value: '${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}'});
return commands;
 }
});

//SwitchTeams
manager.addRollupRule({
 name: 'switchTeam'
 , description: 'Open a team you are a member of MUST BE IN LINK FORMAT lower case no spaces ex: UI Automation would be ui-automation'
 , args: [{ name: 'TeamName', description: 'Open a team you are a member of'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "//a[@href='/"+args.TeamName+"']", value: ''});
commands.push({ command: 'click', target: "//a[@href='/"+args.TeamName+"']", value: ''});
return commands;
 }
});

//Close RHS
manager.addRollupRule({
 name: 'closeRHS'
 , description: 'Closes RHS'
 , args: [], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "css=button.sidebar--right__close", value: ''});
commands.push({ command: 'click', target: "css=button.sidebar--right__close", value: ''});
return commands;
 }
});

//openDotMenuForLastPost
manager.addRollupRule({
 name: 'openDotMenuForLastPost'
 , description: 'Open the ... menu of the last post made'
 , args: [], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'storeAttribute', target: "//div[@id='postListContent']//*/div[contains(@style,'position: relative;')][last()]/*//div[contains(@id,'post_')]@id", value: 'LastPostIdFull'});
commands.push({ command: 'waitForElementPresent', target: "//div[@id='${LastPostIdFull}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'mouseOver', target: "//div[@id='${LastPostIdFull}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[@class='post__dropdown color--link style--none']", value: ''});
commands.push({ command: 'click', target: "//button[@class='post__dropdown color--link style--none']", value: ''});
return commands;
 }
});

//openDotMenuByText NEED FIX
manager.addRollupRule({
 name: 'openDotMenuByPostText'
 , description: 'Open the ... menu for the post containg provided text. Will select earlies matching post that has been loaded in the channel. (case sensitive match)'
 , args: [{ name: 'ContainsText' , description: 'Match earliest post containing the following text' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'storeAttribute', target: "//p[contains(text(),'"+args.ContainsText+"')/parent::div[@class='post-message__text']/parent::div[@class='post-message__text-container']/parent::div[@class='post-message post-message--collapsed']/parent::div[@id]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div@id]", value: 'PostByText'});
commands.push({ command: 'waitForElementPresent', target: "//div[@id='${PostByText}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'mouseOver', target: "//div[@id='${PostByText}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "css=button.dropdown-toggle.post__dropdown.color--link.style--none", value: ''});
commands.push({ command: 'click', target: "css=button.dropdown-toggle.post__dropdown.color--link.style--none", value: ''});
return commands;
 }
});


//openReplyRhsForLastPost
manager.addRollupRule({
 name: 'openReplyRhsForLastPost'
 , description: 'Open the Reply menu of the last post made'
 , args: [], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'storeAttribute', target: "//div[@id='postListContent']//*/div[contains(@style,'position: relative;')][last()]/*//div[contains(@id,'post_')]@id", value: 'LastPostIdFull'});
commands.push({ command: 'waitForElementPresent', target: "//div[@id='${LastPostIdFull}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'mouseOver', target: "//div[@id='${LastPostIdFull}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[@class='comment-icon__container color--link style--none pull-right']", value: ''});
commands.push({ command: 'click', target: "//button[@class='comment-icon__container color--link style--none pull-right']", value: ''});
return commands;
 }
});

//openReplyRhsByText
manager.addRollupRule({
 name: 'openReplyRhsByText'
 , description: 'Open the Reply menu for the post containg provided text. Will select earlies matching post that has been loaded in the channel. (case sensitive match)'
 , args: [{ name: 'ContainsText' , description: 'Match earliest post containing the following text' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'storeAttribute', target: "//p[contains(text(),'"+args.ContainsText+"')]/parent::div[@class='post-message__text']/parent::div[@class='post-message__text-container']/parent::div[@class='post-message post-message--collapsed']/parent::div[@id]/parent::div/parent::div/parent::div/parent::div@id", value: 'PostByText'});
commands.push({ command: 'waitForElementPresent', target: "//div[@id='${PostByText}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'mouseOver', target: "//div[@id='${PostByText}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[@class='comment-icon__container color--link style--none pull-right']", value: ''});
commands.push({ command: 'click', target: "//button[@class='comment-icon__container color--link style--none pull-right']", value: ''});
return commands;
 }
});


//openEmojiPickerForLastPost
manager.addRollupRule({
 name: 'openEmojiPickerForLastPost'
 , description: 'Open the ... menu of the last post made'
 , args: [], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'storeAttribute', target: "//div[@id='postListContent']//*/div[contains(@style,'position: relative;')][last()]/*//div[contains(@id,'post_')]@id", value: 'LastPostIdFull'});
commands.push({ command: 'waitForElementPresent', target: "//div[@id='${LastPostIdFull}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'mouseOver', target: "//div[@id='${LastPostIdFull}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[@class='reacticon__container color--link style--none']", value: ''});
commands.push({ command: 'click', target: "//button[@class='reacticon__container color--link style--none']", value: ''});
return commands;
 }
});

//openEmojiPickerByText - Needs FIX
manager.addRollupRule({
 name: 'openEmojiPickerByText'
 , description: 'Open the ... menu for the post containg provided text. Will select earlies matching post that has been loaded in the channel. (case sensitive match)'
 , args: [{ name: 'ContainsText' , description: 'Match earliest post containing the following text' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'storeAttribute', target: "//p[contains(text(),'"+args.ContainsText+"')]/parent::div[@class='post-message__text']/parent::div[@class='post-message__text-container']/parent::div[@class='post-message post-message--collapsed']/parent::div[@id]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div@id", value: 'PostByText'});
commands.push({ command: 'waitForElementPresent', target: "//div[@id='${PostByText}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'mouseOver', target: "//div[@id='${PostByText}']/div[@class='post__content ']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[@class='reacticon__container color--link style--none']", value: ''});
commands.push({ command: 'click', target: "//button[@class='reacticon__container color--link style--none']", value: ''});
return commands;
 }
});


//VerifyAndSelectDotMenuItem
manager.addRollupRule({
 name: 'dotMenuItemVerifyAndSelect'
 , description: 'Verifies the desired item is visble on the dot menu then selects it. Case sensitive'
 , args: [{ name: 'Item', description: 'Provide Item needed'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "//li[@class='MenuItem']/button[text() = '"+args.Item+"']", value: ''});
commands.push({ command: 'click', target: "//li[@class='MenuItem']/button[text() = '"+args.Item+"']", value: ''});
return commands;
 }
});

//VerifyDotMenuItem
manager.addRollupRule({
 name: 'dotMenuItemVerify'
 , description: 'Verifies the desired item is visble on the dot menu. Does not select it. Case sensitive'
 , args: [{ name: 'Item', description: 'Provide Item needed'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "//li[@class='MenuItem']/button[text() = '"+args.Item+"']", value: ''});
return commands;
 }
});

//VerifyDotMenuItemNotPresent
manager.addRollupRule({
 name: 'dotMenuItemVerifyNotPresent'
 , description: 'Verifies the desired item is NOT visble on the dot menu. Case sensitive'
 , args: [{ name: 'Item', description: 'Provide Item needed'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementNotPresent', target: "//li[@class='MenuItem']/button[text() = '"+args.Item+"']", value: ''});
return commands;
 }
});


//Open Channel Menu
manager.addRollupRule({
 name: 'openChanMenu'
 , description: 'Open channel menu of the channel you are currently viewing'
 , args: [], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "id=channelHeaderDropdownIcon", value: ''});
commands.push({ command: 'click', target: "id=channelHeaderDropdownIcon", value: ''});

return commands;
 }
});


//ChanMenuItemVerifyAndSelect
manager.addRollupRule({
 name: 'chanMenuItemVerifyAndSelect'
 , description: 'Verifies the desired item is visble in the channel menu and sekects it. Case sensitive'
 , args: [{ name: 'Item', description: 'Provide the menu item needed'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "//ul[@id='channelHeaderDropdownMenu']/li/button[text() = '"+args.Item+"']", value: ''});
commands.push({ command: 'click', target: "//ul[@id='channelHeaderDropdownMenu']/li/button[text() = '"+args.Item+"']", value: ''});
return commands;
 }
});


//ChanMenuItemVerify
manager.addRollupRule({
 name: 'chanMenuItemVerify'
 , description: 'Verifies the desired item is visble in the channel menu. Does not select it. Case sensitive'
 , args: [{ name: 'Item', description: 'Provide the menu item needed'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "//ul[@id='channelHeaderDropdownMenu']/li/button[text() = '"+args.Item+"']", value: ''});
return commands;
 }
});


//VerifyChannelMenuItemNotPresent
manager.addRollupRule({
 name: 'chanMenuItemVerifyNotPresent'
 , description: 'Verifies the desired item is NOT visble in the channel menu. Case sensitive'
 , args: [{ name: 'Item', description: 'Provide Item needed'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementNotPresent', target: "//ul[@id='channelHeaderDropdownMenu']/li/button[text() = '"+args.Item+"']", value: ''});
return commands;
 }
});


//Promote user to Team Admin
manager.addRollupRule({
 name: 'promoteUserToTeamAdmin'
 , description: 'Promtes user provided to Team Admin of the team provided. ex: username=test1, team=UI Automation'
 , args: [{ name: 'username' , description: 'team' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "//span[@class='sidebar-header-dropdown__icon']", value: ''});
commands.push({ command: 'click', target: "//span[@class='sidebar-header-dropdown__icon']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "id=systemConsole", value: ''});
commands.push({ command: 'click', target: "id=systemConsole", value: ''});
commands.push({ command: 'waitForElementPresent', target: "id=users", value: ''});
commands.push({ command: 'click', target: "id=users", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div/a/span/span[contains(text(),'Member')]", value: ''});
commands.push({ command: 'click', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div/a/span/span[contains(text(),'Member')]", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div/ul[@class='dropdown-menu member-menu']/li[@role='presentation']/a[@id='manageTeams']/span", value: ''});
commands.push({ command: 'click', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div/ul[@class='dropdown-menu member-menu']/li[@role='presentation']/a[@id='manageTeams']/span", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='manage-teams__team-name'][contains(text(),'"+args.team+"')]/parent::div[@class='manage-teams__team']/div[@class='manage-teams__team-actions']/div/a[@class='dropdown-toggle']", value: ''});
commands.push({ command: 'click', target: "//div[@class='manage-teams__team-name'][contains(text(),'"+args.team+"')]/parent::div[@class='manage-teams__team']/div[@class='manage-teams__team-actions']/div/a[@class='dropdown-toggle']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "id=makeTeamAdmin", value: ''});
commands.push({ command: 'click', target: "id=makeTeamAdmin", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//span[contains(text(),'×')]", value: ''});
commands.push({ command: 'click', target: "//span[contains(text(),'×')]", value: ''});
commands.push({ command: 'waitForElementPresent', target: "id=adminNavbarDropdownButton", value: ''});
commands.push({ command: 'click', target: "id=adminNavbarDropdownButton", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//ul[@class='dropdown-menu']/li/a[text() = '"+args.team+"']", value: ''});
commands.push({ command: 'click', target: "//ul[@class='dropdown-menu']/li/a[text() = '"+args.team+"']", value: ''});
return commands;
 }
});


//Promote user to System Admin
manager.addRollupRule({
 name: 'promoteUserToSystemAdmin'
 , description: 'Promtes user provided to System Admin'
 , args: [{ name: 'username' , description: 'Provide user to promote to System Admin' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
//Get current Team
commands.push({ command: 'waitForElementPresent', target: "//div[@class='team-container active']/a", value: ''});
commands.push({ command: 'storeAttribute', target: "//div[@class='team-container active']/a@href", value: 'TeamWithSlash'});
commands.push({ command: 'assertText', target: "id=post_textbox", value: ''});
commands.push({ command: 'sendKeys', target: "id=post_textbox", value: '${TeamWithSlash}'});
commands.push({ command: 'sendKeys', target: "id=post_textbox", value: '${KEY_HOME}'});
commands.push({ command: 'sendKeys', target: "id=post_textbox", value: '${KEY_DELETE}'});
commands.push({ command: 'storeText', target: "//textarea[@id='post_textbox']", value: 'TeamName'});
commands.push({ command: 'pause', target: "", value: '1000'});
commands.push({ command: 'sendKeys', target: "id=post_textbox", value: '${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}${KEY_DELETE}'});
//Promote User
commands.push({ command: 'waitForElementPresent', target: "//span[@class='sidebar-header-dropdown__icon']", value: ''});
commands.push({ command: 'click', target: "//span[@class='sidebar-header-dropdown__icon']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "id=systemConsole", value: ''});
commands.push({ command: 'click', target: "id=systemConsole", value: ''});
commands.push({ command: 'waitForElementPresent', target: "id=users", value: ''});
commands.push({ command: 'click', target: "id=users", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div/a/span/span[contains(text(),'Member')]", value: ''});
commands.push({ command: 'click', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div/a/span/span[contains(text(),'Member')]", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div/ul[@class='dropdown-menu member-menu']/li[@role='presentation']/a[@id='manageRoles']/span", value: ''});
commands.push({ command: 'click', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div/ul[@class='dropdown-menu member-menu']/li[@role='presentation']/a[@id='manageRoles']/span", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//input[@name='systemadmin']", value: ''});
commands.push({ command: 'click', target: "//input[@name='systemadmin']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button/span[contains(text(),'Save')] ", value: ''});
commands.push({ command: 'click', target: "//button/span[contains(text(),'Save')] ", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div/a/span/span[contains(text(),'System Admin')]", value: ''});
//Return to Team
commands.push({ command: 'waitForElementPresent', target: "id=adminNavbarDropdownButton", value: ''});
commands.push({ command: 'click', target: "id=adminNavbarDropdownButton", value: ''});
commands.push({ command: 'waitForElementPresent', target: "id=swithTo${TeamName}", value: ''});
commands.push({ command: 'click', target: "id=swithTo${TeamName}", value: ''});
return commands;
 }
});


//Promote user to channel Admin
manager.addRollupRule({
 name: 'promoteUserToChannelAdmin'
 , description: 'Promotes user provided to Admin of the current channel'
 , args: [{ name: 'username', description: 'User to be promoted'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "id=channelHeaderTitle", value: ''});
commands.push({ command: 'click', target: "id=channelHeaderDropdownButton", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//ul[@id='channelHeaderDropdownMenu']/li/button[text() = 'Manage Members']", value: ''});
commands.push({ command: 'click', target: "//ul[@id='channelHeaderDropdownMenu']/li/button[text() = 'Manage Members']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][text() = '@"+args.username+"']/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div[@class='MenuWrapper ']/button ", value: ''});
commands.push({ command: 'click', target: "//div[@class='more-modal__name'][text() = '@"+args.username+"']/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div[@class='MenuWrapper ']/button ", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//li[@class='MenuItem']/button[contains(text(),'Make Channel Admin')]", value: ''});
commands.push({ command: 'click', target: "//li[@class='MenuItem']/button[contains(text(),'Make Channel Admin')]", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[@class='close']", value: ''});
commands.push({ command: 'click', target: "//button[@class='close']", value: ''});
return commands;
 }
});

//Remove user from channel 
manager.addRollupRule({
 name: 'removeUserFromChannel'
 , description: 'Removes the user provided from the current channel'
 , args: [{ name: 'username', description: 'User to be removed'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "id=channelHeaderTitle", value: ''});
commands.push({ command: 'click', target: "id=channelHeaderDropdownButton", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//ul[@id='channelHeaderDropdownMenu']/li/button[text() = 'Manage Members']", value: ''});
commands.push({ command: 'click', target: "//ul[@id='channelHeaderDropdownMenu']/li/button[text() = 'Manage Members']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][text() = '@"+args.username+"']/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div[@class='MenuWrapper ']/button ", value: ''});
commands.push({ command: 'click', target: "//div[@class='more-modal__name'][text() = '@"+args.username+"']/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div[@class='MenuWrapper ']/button ", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//li[@class='MenuItem']/button[contains(text(),'Remove From Channel')]", value: ''});
commands.push({ command: 'click', target: "//li[@class='MenuItem']/button[contains(text(),'Remove From Channel')]", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[@class='close']", value: ''});
commands.push({ command: 'click', target: "//button[@class='close']", value: ''});
return commands;
 }
});

//Remove user from team 
manager.addRollupRule({
 name: 'removeUserFromTeam'
 , description: 'Removes the user provided from the current team'
 , args: [{ name: 'username', description: 'User to be removed'  }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "id=sidebarHeaderDropdownButton", value: ''});
commands.push({ command: 'click', target: "id=sidebarHeaderDropdownButton", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//li[@id='manageMembers']/button", value: ''});
commands.push({ command: 'click', target: "//li[@id='manageMembers']/button", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='a11y__modal more-modal modal-dialog']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][text() = '@"+args.username+"']/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div[@class='MenuWrapper ']/button[@class='dropdown-toggle theme color--link style--none']", value: ''});
commands.push({ command: 'click', target: "//div[@class='more-modal__name'][text() = '@"+args.username+"']/parent::div[@class='more-modal__details']/following-sibling::div[@class='more-modal__actions']/div[@class='MenuWrapper ']/button[@class='dropdown-toggle theme color--link style--none']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//li[@id='removeFromTeam']/button[contains(text(),'Remove From Team')]", value: ''});
commands.push({ command: 'click', target: "//li[@id='removeFromTeam']/button[contains(text(),'Remove From Team')]", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[@class='close']", value: ''});
commands.push({ command: 'click', target: "//button[@class='close']", value: ''});
return commands;
 }
});


//Create Team
manager.addRollupRule({
 name: 'createTeam'
 , description: 'Creates a closed Team. DOES NOT SUPPORT SPACES OR UPPERCASE LETTERS'
 , args: [{ name: 'TeamName' , description: 'team name to be created' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "id=sidebarHeaderDropdownButton", value: ''});
commands.push({ command: 'click', target: "id=sidebarHeaderDropdownButton", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//li[@id='createTeam']/a", value: ''});
commands.push({ command: 'click', target: "//li[@id='createTeam']/a", value: ''});
commands.push({ command: 'waitForElementPresent', target: "css=input.form-control", value: ''});
commands.push({ command: 'type', target: "css=input.form-control", value: args.TeamName});
commands.push({ command: 'waitForElementPresent', target: "//button[@type='submit']", value: ''});
commands.push({ command: 'click', target: "//button[@type='submit']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//input[@value='"+args.TeamName+"']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//span[contains(text(),'Finish')]", value: ''});
commands.push({ command: 'click', target: "//button[@type='submit']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='team-container active']/a[@href='/"+args.TeamName+"']", value: ''});
return commands;
 }
});


//Add user to team
manager.addRollupRule({
 name: 'addUserToTeam'
 , description: 'Add user to current team'
 , args: [{ name: 'username' , description: 'User to be added to the team' }], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementPresent', target: "id=sidebarHeaderDropdownButton", value: ''});
commands.push({ command: 'click', target: "id=sidebarHeaderDropdownButton", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//li[@id='addUsersToTeam']/button", value: ''});
commands.push({ command: 'click', target: "//li[@id='addUsersToTeam']/button", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]", value: ''});
commands.push({ command: 'click', target: "//div[@class='more-modal__name'][contains(text(),'@"+args.username+"')]", value: ''});
commands.push({ command: 'click', target: "id=saveItems", value: ''});
return commands;
 }
});

//openReplyDotMenuForTopPost
manager.addRollupRule({
 name: 'openReplyDotMenuForTopPost'
 , description: 'Open the ... menu of the Top post in Reply thread'
 , args: [], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'storeAttribute', target: "//div[@class='post-right__scroll']//*/div[contains(@id,'postMessageText_')][last()]@id", value: 'TopRhsPost'});
commands.push({ command: 'waitForElementPresent', target: "//div[@id='${TopRhsPost}']/p", value: ''});
commands.push({ command: 'mouseOver', target: "//div[@id='${TopRhsPost}']/p", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[contains(@id,'RHS_ROOT_button_')]", value: ''});
commands.push({ command: 'click', target: "//button[contains(@id,'RHS_ROOT_button_')]", value: ''});
return commands;
 }
});

//openSearchDotMenuForTopPost
manager.addRollupRule({
 name: 'openSearchDotMenuForTopPost'
 , description: 'Open the ... menu of the Top post in Reply thread'
 , args: [], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'storeAttribute', target: "//div[@class='post post--thread']//*/div[contains(@id,'postMessageText_')][last()]@id", value: 'TopSearchPost'});
commands.push({ command: 'waitForElementPresent', target: "//div[@id='${TopSearchPost}']", value: ''});
commands.push({ command: 'mouseOver', target: "//div[@id='${TopSearchPost}']", value: ''});
commands.push({ command: 'waitForElementPresent', target: "//button[@class='post__dropdown color--link style--none']", value: ''});
commands.push({ command: 'click', target: "//button[@class='post__dropdown color--link style--none']", value: ''});
return commands;
 }
});

//Look for extra dividers in channel menu 
manager.addRollupRule({
 name: 'noExtraDeviders'
 , description: 'Ensure there are no extra deviders bars in channel drop down menu. Covers both deviders with no options in between and extra devider at the bottom'
 , args: [], commandMatchers: []
 , getExpandedCommands: function(args) {
 var commands = [];
 
commands.push({ command: 'waitForElementNotPresent', target: "//li[@class='MenuGroup menu-divider']/following-sibling::li[position()=1][@class='MenuGroup menu-divider']", value: ''});

return commands;
 }
});


