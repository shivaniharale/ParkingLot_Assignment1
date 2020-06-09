# ParkingLot_Assignment1
Problem Statement: 

I own a parking lot that can hold up to 'n' cars at any given point in time. Each slot is given a number starting at 1 increasing with increasing distance from the entry point in steps of one. I want to create an automated ticketing system that allows my customers to use my parking lot without human intervention. 

When a car enters my parking lot, I want to have a ticket issued to the driver. The ticket issuing process includes us documenting the registration number (number plate) and the color of the car and allocating an available parking slot to the car before actually handing over a ticket to the driver (we assume that our customers are nice enough to always park in the slots allocated to them). The customer should be allocated a parking-slot that is nearest to the entry.

At the exit, the customer returns the ticket which then marks the slot they were using as being available. Due to government regulation, the system should provide me with the ability to find out:
Registration numbers of all cars of a particular color.
Slot number in which a car with a given registration number is parked.
Slot numbers of all slots where a car of a particular color is parked.

It should provide us with an interactive command prompt based shell where commands can be typed in.

Command List to be supported 
create_parking_lot 
park 
leave 
status 
registration_numbers_for_cars_with_colour 
slot_numbers_for_cars_with_colour
