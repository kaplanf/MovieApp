# MovieApp

# App Layers
The app is built according to MVP pattern with the help of dependency injection library Dagger.
The UI operations are handled in Activity and Fragment classes, isolated from the logic operations.
Network operations are handled by AppDatamanager, which connects to an instance of AppApiHelper with the help of Retrofit.
Logic operations are handled by Presenter classes belonging to each UI fragment and isolated from UI layer.

# Responsibility of Classes
BaseActivity and BaseFragment classes are created for consistency among View classes, also for time saving by eliminating
boilerplate code to be written for every View class.

AppDatamanager uses instances of AppApiHelper and AppPreferencesHelper, for managing network and preference save/load operations.

ActivityModule and ApplicationModule classes are used for providing necessary instances for the specified scope with dependency injection

Every UI element has a Presenter and View interface to define necessary operations in their respective classes, Presenter is responsible of
conducting logic operations and conveying required data to its View class.

Realm library is used for DB operations in case of offline work, and Picasso is used for image caching.

# Principle of Sole Responsibility
The Sole Responsibility principle means every module should be responsible for a single functionality, and that responsibility should
be entirely fulfilled by that class.Its purpose is to write more robust code, to differentiate responsibilities, to make it easier
to change the code if necessary.

# Characteristics of Clean Code
- It should be easily readable
- Reduced complexity as much as possible
- Following standard conventions
- Small functions with descriptive names
- Easy to change/refactor
- Modular, differentiated responsibilities
