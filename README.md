# Android In Depth

## App Lifecycle


## App Architecture


## Background work of an App
### Definition of background work:
Referece: https://developer.android.com/guide/background
- None of the app's activities are currently visible to the user.
- The app isn't running any foreground services that started while an activity from the app was visible to the user.

### Common types of background work:
- Immediate: need to execute right away and complete soon
- Long running: may take some time to complete
- Deferrable: does not need to run right away
- Background work can be either *persistent* or *impersistent*
    - All persistent work should use **WorkManager**
    - For Immediate impersistant work, use **Kotlin coroutines** or **Java Threading**
    - For long-running and deferrable impersistent work, it is not recommended, should complete tasks through persistent work using WorkManager.

1. Immediate work:
    - Immediate work encompasses tasks which need to execute right away. These are tasks which are important to the user or which you otherwise can't schedule for deferred execution at a later time. They are important enough that they might need to remain scheduled for prompt execution even if the app closes or the device restarts.

2. Long-running work:
    - Work is long running if it is likely to take more than ten minutes to complete.

3. Deferrable work:
    - Deferrable work is any work that does not need to run right away.

### Ways to work in background concurrently
1. AsyncTask
2. Service
3. IntentService
4. Thread
5. Handler
6. HandlerThread

### Modern way of doing background work
1. JobIntentService
2. WorkManager
3. Background Service
4. Foreground Service

### WorkManager API
- 


## Android Debug Bridge (ABD)
https://www.youtube.com/watch?v=uOPcUjVl2YQ
