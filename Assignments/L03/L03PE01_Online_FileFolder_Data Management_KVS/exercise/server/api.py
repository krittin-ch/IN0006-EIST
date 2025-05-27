from flask import Blueprint, request, current_app, Response
import http.client
from ff import Entry, FileFolder

api = Blueprint("api", __name__, template_folder="templates")

# Messages
#   use "MESSAGWE % (param1, param2, ...)" to insert parameters into message
KEY_DOES_NOT_EXIST = "Key %s does not exist!"
NO_UID_IN_REQUEST_BODY = "No 'uid' in request body. The request must provide user id!"
NO_ACCESS_TO_ENTRY = "Cannot access the content associated with key %s. Owned by other user!"
NO_CONTENT_IN_REQUEST_BODY = "No 'content' in request body. The request must provide the content!"
NO_SPACE_IN_FILE_FOLDER = "Failed to add the content. No empty space!"
PUT_SUCCESS = "Successfully added the content."

# Response status
#   create a response like this:
#   response = Response(message, status=OK)
OK = http.client.OK  # 200
BAD_REQUEST = http.client.BAD_REQUEST  # 400
NOT_FOUND = http.client.NOT_FOUND  # 404

####################################################
# TODO: Implement the endpoints of the RESTful API #
####################################################

@api.route("/<key>", methods=["GET"])
def get(key: str) -> Response:    
    """
    Retrieve the file-content associated with the given key owned by the user.
    If there is no user-id `uid` given in the request body or the user-id does not match, return error message and status.
    Otherwise, return the file-content and success status.
    """
    request_body: dict = request.json
    ff: FileFolder = current_app.ff

    pass


@api.route("/<key>", methods=["POST"])
def put(key: str) -> Response:    
    """
    Upsert a file-content associated with the given key owned by the user.
    If there is no user-id `uid` or file-content `content` given in the request body, return error message and status.
    Otherwise, return the success message and success status
    """
    request_body: dict = request.json
    ff: FileFolder = current_app.ff

    pass


@api.route("/<key>", methods=["DELETE"])
def remove(key: str) -> Response:
    """
    Remove the file-content associated with the given key owned by the user.
    If there is no user-id `uid` given in the request body or the user-id does not match, return error message and status.
    Otherwise, return the removed file-content and success status
    """
    request_body: dict = request.json
    ff: FileFolder = current_app.ff

    pass


@api.route("/", methods=["GET"])
def list() -> Response:
    """
    List all (key, file-content) tuples owned by the user.
    If there is no user-id `uid` given in the request body, return error message and status.
    Otherwise, return the list of file-content and success status.
    """
    request_body: dict = request.json
    ff: FileFolder = current_app.ff

    pass

####################################################
# TODO end                                         #
####################################################
