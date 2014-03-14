slamhound-lt
============

Slamhoundify (thats definitly a word) the currently active file in LightTable.

![Screenshot](http://chadhq.com/content/images/2014/Mar/slamhound_3.jpg)

##Usage

Plugin is available via LightTable 'Commands' lookup. Just start typing 'slamh...' and run the `Slamound-lt: Preview` command.

Optionally assign shortcut to `:lt.plugins.slamhound-lt/slamhound` command in you `user.keymap` file.               

i.e. `"ctrl-shift-s" [:lt.plugins.slamhound-lt/slamhound]`

##Whats Next...

Currently only provides the inline suggestion, which you must manually copy / paste over your current ns declaration.

Future versions will have the option to automatically replace the ns with the slamhound suggestion. Honestly, I'm still working out the LightTable framework so pull requests are very welcome if anyone wants to help out on this :-)

##Installation

Available in the central plugin repository.
You might need to run `Refresh plugin list`, `Reload app behaviors`
commands after installation.
