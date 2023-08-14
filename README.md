# ProjectManagementBoardAPI
# Project Management Board

This project is a simple web-based project management board application. It allows users to create boards, add cards to boards, and manage the cards within different sections. The application also provides features for editing and deleting both boards and cards.

## Features

- Create a new board with a title.
- Add cards to a board with title, description, and section.
- View and manage cards within different sections of a board.
- Edit board title.
- Edit card details (title, description, section).
- Delete boards and cards.
- User-friendly interface for easy management of project tasks.

## Technologies Used

- HTML
- CSS
- JavaScript
- Fetch API for communication with the server

## How to Use

1. Clone or download this repository to your local machine.
2. Use the provided form to create new boards.
3. Click "View Cards" to manage cards within a board.
4. Use the "Edit" and "Delete" buttons to make changes or remove boards and cards.

## API Endpoints

The application communicates with a server using the following API endpoints:

- `POST /board/api/boards`: Create a new board.
- `GET /board/api/boards`: Get all boards.
- `PUT /board/api/boards/:boardId`: Update a board by ID.
- `DELETE /board/api/boards/:boardId`: Delete a board by ID.
- `POST /board/api/boards/:boardId/cards`: Add a new card to a board.
- `GET /board/api/boards/:boardId/cards`: Get all cards from a board.
- `PUT /board/api/boards/:boardId/cards/:cardId`: Update a card on a board.
- `DELETE /board/api/boards/:boardId/cards/:cardId`: Delete a card from a board.

## Contributor

This project was created by Abdulaziz
