# Data management KVS - Main - Online FileFolder

In the basic exercise of our KVS we implemented a local file folder to manage our files. In this exercise, we want to make the file folder _online_ by implementing a client-server model. To prevent users from accessing other users files, we attach the user-id along with the content, meaning each key would be associated with an `Entry` including a user-id `uid` and the content `content` (details in `ff.py`). The implementation of the `FileFolder` class stays unchanged comparing to the basic exercise.

Your task now is to implement the _server_ API handlers for handling the file-folder action requests and the client for sending the file-folder action requests. In this exercise, we use flask to implement the server. A quickstart on how to implement the Flask API handlers can be found [here](https://flask.palletsprojects.com/en/stable/tutorial/views/).

The exercise is implemented in Python. Check the README file after you clone the repository for an explanation how to install Python, the necessary dependencies and start the application.

## Part 1: Server

In `server/api.py`, we want to define 4 handlers for the file-folder CRUD actions: `put`, `get`, `remove` and `list`.

1. **Get-handler**

    Implement the handler to retrieve the file content associated with the given key. The handler should behave as following:

    - A call of this endpoint will return a [flask.Response](https://tedboy.github.io/flask/generated/generated/flask.Response.html) with the value in the filefolder associated with the given key. I.e. the content of the returned `Entry`. As well as a response status of OK.
    - Handle the case that the key does not exist. Return response with appropriate error message, and status.
    - Don't allow a user to access other users files. Test for `uid` existence and correctness in request body. Return response with appropriate error messages and status.

2. **Put-handler**
    
    Implement the handler to register a new file content or update an existing file content associated with the given key. The handler should behave as following:

    - A successful call of this endpoint will set or update a key-value pair in the database and will return a response with the specified success message and an OK state.
    - Handle the lack of `uid` or `content` within the request body. Return appropriate response with message and state.
    - If an entry with this key already exists test for correct `uid` and return response with success/error message and state.
    - If not, check if the database has enough capacity left and return response with success/error message and state.

3. **Remove-handler**

    Implement the handler to delete the content associated with the given key from the file folder. The handler should behave as following:

    - On success, return a response with the removed value and OK state.
    - Handle the lack of `uid` within the request body.
    - Handle the case that the key does not exist. Return appropriate response with error message and status.

4. **List-handler**

    Implement the handler to list all key-content pairs in the file folder. Meet the following requirements:

    - On success, return a response with a string representation of all key-value pairs and a OK state. Represent the pairs following the pattern `"key:value, key2:value2, ..., keyN:valueN"`
    - Handle the lack of `uid` within the request body. Note that you have to check the uid for each file individually.

## Part 2: Client Side

In the `client/client.py`, we want to implement 4 client action methods: `get`, `put`, `remove` and `list`

1. **Read-action**

    Implement the read-action which retrieves the file-content associated with `key` owned by `uid` and return the server response.

2. **Put-action**
    
    Implement the put-action which registers a new file-content (if `key` is unavailable in file folder) or updates the existing `content` owned by `uid` and return the server response.

3. **Remove-action**
    
    Implement the remove-action which deletes the content associated with given `key` owned by `uid` and return the server response.

4. **List-action**
    
    Implement the list-action which lists all pair (key, file-content) owned by `uid` and return the server response.

## Part 3: Optional Challenges

(These are not tested)

1. Think of an application that could use this system you've built.
2. Think of how to expand this example.
