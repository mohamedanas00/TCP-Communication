## TCP Communication for Mathematical Operations

Provides examples of TCP communication between a client and a server for performing mathematical operations. It includes both single-threaded and multi-threaded server implementations to handle client requests concurrently.
## Message Design
The message format consists of three components separated by a delimiter, typically a colon (:):

Operator: Represents the mathematical operation to be performed. It could be one of the following:

* Addition (+)
* Subtraction (-)
* Multiplication (*)
* Division (/)
Operand 1: The first operand of the operation. It can be any numeric value (integer or floating-point).

Operand 2: The second operand of the operation. Similar to the first operand, it can be any numeric value
---------------------------------------------------------------------
## Simple Communication Example (TCP Communication)
This Java code establishes a simple TCP communication between a client and a server. The client sends messages to the server, which in turn displays them. The communication continues until the client sends the message "stop". 

## Communication
- Enter messages in the client console. They will be sent to the server.
- The server receives and displays the messages until it receives "stop" from the client.
- To end the communication, type "stop" in the client console.

## Notes
- Ensure the server is running before starting the client.
- The server will keep running until it receives the "stop" message from the client or encounters an error.
- This code serves as a basic framework for understanding TCP socket communication in Java and can be extended for more complex applications

