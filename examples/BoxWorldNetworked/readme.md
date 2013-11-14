# Box world networked
This example is a networked version of the BoxWorld. There are two src folders. The server and the box world client. We now describe both these projects.

## Server
The server is console based network server. When started it binds a socket to
localhost and listens to port 7575 (TCP). When a given client connects, the
server creates a new thread that handles the socket communication between the client and the server. Thus, this server is multithreaded. When the client disconnects or the server gets i/o errors, the thread is killed and other connected clients are notified.

## Client
When the BoxWorld client is started we create a network thread that connects to the server.
each client is responsible for keeping their own version of the game state (should also be stored on the client for verifications purposes). When server sends information regarding changes in the Box world, clients must update their representation of the world and draw it with respect to that representation.

When you use the ADWS keys the client sends move messages to the server. The server broadcasts these informations to other connected clients that can draw you moving around the box world.

## Protocol
The protocol used in this example is a text based protocol using CSV format.
When a client connects the server generates a nick for the client (MD5 sum from
connection time). The server then notifies other clients with a join messages, as follows:

    join;nick

When client receive this message they know that a new client has joined the world.

The connecting client is then notified of other users that were connected before him
with an online message as follows:

    online;nick

for each client that is connected. With this message the client can immediately start drawing
other players in the world.

When a given users quits, connected clients are notified with a quit message.

        quit;nick 

When clients receive this message, they can start drawing the box for that client.

When a given client moves, a move message is broad casted to all clients:

        move;nick;x,y,z

With this message everyone is notified when a client moves.

## Limitation
This code is a good starting point for students that want to play with networking
in their assignments. Note that the protocol above is limited and need to be altered
and modified to fit your needs. Also we only thinking about (x,y,z) movements where
you will most likly need to send other information over the wire, such as rotation and such.

I hope you can use this code. If you have any question regarding this code -- please
send me an email (hlysig@gagnavarslan.is)
