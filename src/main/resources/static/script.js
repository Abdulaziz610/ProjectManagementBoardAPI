let currentBoardId = null;
// Function to create a new board
async function createBoard(title) {
    const boardRequest = { title };
    const response = await fetch('/board/api/boards', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(boardRequest)
    });
    const data = await response.json();
    return data;
}


// Function to get all boards
async function getAllBoards() {
    const response = await fetch('/board/api/boards');
    const data = await response.json();
    return data.boards;
}

// Function to update a board by ID
async function updateBoard(boardId, title) {
    const boardRequest = { title };
    const response = await fetch(`/board/api/boards/${boardId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(boardRequest)
    });
    const data = await response.json();
    return data;
}

// Function to delete a board by ID
async function deleteBoard(boardId) {
    const response = await fetch(`/board/api/boards/${boardId}`, {
        method: 'DELETE',
    });
    const data = await response.json();
    return data;
}

// Function to add a new card to a board
async function addCardToBoard(boardId, cardData) {
    const response = await fetch(`/board/api/boards/${boardId}/cards`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cardData)
    });
    const data = await response.json();
    return data;
}

// Function to get all cards from a board
async function getAllCardsFromBoard(boardId) {
    const response = await fetch(`/board/api/boards/${boardId}/cards`);
    const data = await response.json();
    return data;
}

// Function to update a card on a board
async function updateCardOnBoard(boardId, cardId, cardData) {
    const response = await fetch(`/board/api/boards/${boardId}/cards/${cardId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cardData)
    });
    const data = await response.json();
    return data;
}

// Function to delete a card from a board
async function deleteCardFromBoard(boardId, cardId) {
    const response = await fetch(`/board/api/boards/${boardId}/cards/${cardId}`, {
        method: 'DELETE'
    });
    const data = await response.json();
    return data;
}

// Function to load all boards on page load
async function loadBoards() {
    const boards = await getAllBoards();
    const boardsList = document.getElementById('boardsList');
    boardsList.style.display = 'block'; // Show the board list
    const cardsContainer = document.getElementById('cardsContainer');
    cardsContainer.style.display = 'none'; // Hide the cards list
    boardsList.innerHTML = '';

    boards.forEach(board => {
        const boardElement = document.createElement('div');
        boardElement.innerHTML = `<h2>${board.name}</h2>`;
        const boardButtons = document.createElement('div');
        boardButtons.innerHTML = `
            <button class="view-btn" data-board-id="${board.board_id}">View Cards</button>
            <button class="edit-btn" data-board-id="${board.board_id}">Edit Board</button>
            <button class="delete-btn" data-board-id="${board.board_id}">Delete Board</button>
        `;
        boardElement.appendChild(boardButtons);
        boardsList.appendChild(boardElement);
    });

    const viewButtons = document.getElementsByClassName('view-btn');
    const editButtons = document.getElementsByClassName('edit-btn');
    const deleteButtons = document.getElementsByClassName('delete-btn');

    for (let i = 0; i < viewButtons.length; i++) {
        viewButtons[i].addEventListener('click', () => {
            const boardId = viewButtons[i].getAttribute('data-board-id');
            showCards(boardId);
        });
    }

    for (let i = 0; i < editButtons.length; i++) {
        editButtons[i].addEventListener('click', () => {
            const boardId = editButtons[i].getAttribute('data-board-id');
            editBoard(boardId);
        });
    }

    for (let i = 0; i < deleteButtons.length; i++) {
        deleteButtons[i].addEventListener('click', () => {
            const boardId = deleteButtons[i].getAttribute('data-board-id');
            deleteBoard(boardId);
        });
    }
}

// Function to handle the form submission and create a new board
document.getElementById('createBoardForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const boardTitle = document.getElementById('boardTitle').value;
    await createBoard(boardTitle);
    loadBoards();
});

// Function to show all cards for a specific board
async function showCards(boardId) {
    currentBoardId = boardId;
    const cards = await getAllCardsFromBoard(boardId);
    const boardList = document.getElementById('boardsList');
    boardList.style.display = 'none';
    const cardsContainer = document.getElementById('cardsContainer');
    cardsContainer.style.display = 'block';

    // Clear existing cards from all columns
    const todoContainer = document.getElementById('todoCards');
    const inProgressContainer = document.getElementById('inprogressCards');
    const doneContainer = document.getElementById('doneCards');
    todoContainer.innerHTML = '';
    inProgressContainer.innerHTML = '';
    doneContainer.innerHTML = '';

    const boardTitle = document.createElement('h2');
    boardTitle.textContent = `Board ID: ${boardId}`;
    cardsContainer.insertBefore(boardTitle, cardsContainer.firstChild);

    if (cards.length === 0) {
        const noCardsMessage = document.createElement('p');
        noCardsMessage.textContent = 'No cards found for this board.';
        cardsContainer.appendChild(noCardsMessage);
    } else {
        cards.forEach(card => {
            const cardItem = document.createElement('div');
            cardItem.classList.add('card');
            cardItem.innerHTML = `
                <p><strong>Card ID:</strong> ${card.card_id}</p>
                <p><strong>Title:</strong> ${card.title}</p>
                <p><strong>Description:</strong> ${card.description ? card.description : 'N/A'}</p>
            `;

            const targetContainerId = `${sectionToContainerId(card.section)}Cards`;
            const targetContainer = document.getElementById(targetContainerId);
            targetContainer.appendChild(cardItem);

            cardItem.addEventListener('click', () => {
                handleCardClick(card.card_id, card.section + 1);
            });
        });
    }
}


// Create a new card form
     const addCardForm = document.createElement('form');
    addCardForm.innerHTML = `
         Card Title: <input type="text" id="cardTitle" required> Card Description:
        <input type="text" id="cardDescription" required>
        <select id="cardSection" required>
            <option value="">Select Section</option>
            <option value="1">To Do</option>
            <option value="2">In Progress</option>
            <option value="3">Done</option>
        </select>
        <button type="submit">Add Card</button>
    `;

    addCardForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const cardTitle = document.getElementById('cardTitle').value;
        const cardDescription = document.getElementById('cardDescription').value;
        const cardSection = parseInt(document.getElementById('cardSection').value);
        if (cardTitle && cardDescription && cardSection >= 1 && cardSection <= 3) {
            await addCardToBoard(boardId, { title: cardTitle, description: cardDescription, section: cardSection });
            showCards(boardId);
        }
    });

    cardsList.appendChild(addCardForm);


        const editCardForm = document.createElement('form');
        editCardForm.innerHTML = `
            <label for="editCardId">Card ID:</label>
            <input type="text" id="editCardId" required>
            <label for="editCardTitle">Title:</label>
            <input type="text" id="editCardTitle" required>
            <label for="editCardDescription">Description:</label>
            <input type="text" id="editCardDescription">
            <label for="editCardSection">Section:</label>
            <select id="editCardSection" required>
                <option value="">Select Section</option>
                <option value="1">To Do</option>
                <option value="2">In Progress</option>
                <option value="3">Done</option>
            </select>
            <button type="submit">Update Card</button>
        `;

        editCardForm.addEventListener('submit', async (e) => {
            e.preventDefault();
            const cardId = document.getElementById('editCardId').value;
            const cardTitle = document.getElementById('editCardTitle').value;
            const cardDescription = document.getElementById('editCardDescription').value;
            const cardSection = parseInt(document.getElementById('editCardSection').value);

            if (!cardId || !cardTitle || isNaN(cardSection) || cardSection < 1 || cardSection > 3) {
                alert('Please provide valid inputs for Card ID, Title, and Section (1 - To do, 2 - In progress, 3 - Done).');
                return;
            }

            await updateCardOnBoard(boardId, cardId, { title: cardTitle, description: cardDescription, section: cardSection });
            showCards(boardId);
        });

        cardsList.appendChild(editCardForm);
    function sectionToContainerId(section) {
        switch (section) {
            case 1:
                return 'todo';
            case 2:
                return 'inprogress';
            case 3:
                return 'done';
            default:
                return 'todo';
        }
    }

  // Function to move a card to a different section
  async function moveCard(cardId, section) {
      const boardId = getCurrentBoardId();
      const cardData = await updateCardOnBoard(boardId, cardId, { section: section });
      showCards(boardId);
  }

    // Function to handle the card click event
    function handleCardClick(cardId, section) {
        if (confirm('Move this card to the selected section?')) {
            moveCard(cardId, section);
        }
    }

// Function to edit a card
async function editCard() {
    const cardId = document.getElementById('editCardId').value;
    const cardTitle = document.getElementById('editCardTitle').value;
    const cardDescription = document.getElementById('editCardDescription').value;
    const cardSection = parseInt(document.getElementById('editCardSection').value);

    if (!cardId || !cardTitle || isNaN(cardSection) || cardSection < 1 || cardSection > 3) {
        alert('Please provide valid inputs for Card ID, Title, and Section (1 - To do, 2 - In progress, 3 - Done).');
        return;
    }

    const boardId = getCurrentBoardId(); // Implement this function to get the current board ID.
    await updateCardOnBoard(boardId, cardId, { title: cardTitle, description: cardDescription, section: cardSection });
    showCards(boardId);
}

// Function to delete a board
async function deleteBoard(boardId) {
    if (confirm('Are you sure you want to delete this board?')) {
        await deleteBoard(boardId);
        loadBoards();
    }
}

// Function to add a new card to a board
async function addCard(boardId) {
    const cardTitle = prompt('Enter the card title:');
    const cardDescription = prompt('Enter the card description:');
    const cardSection = parseInt(prompt('Enter the card section (1 - To do, 2 - In progress, 3 - Done):'));
    if (cardTitle && cardDescription && cardSection >= 1 && cardSection <= 3) {
        await addCardToBoard(boardId, { title: cardTitle, description: cardDescription, section: cardSection });
        showCards(boardId);
    }
}


function getCurrentBoardId() {

    return currentBoardId;
}




// Function to delete a card
async function deleteCard() {
    const boardId = getCurrentBoardId(); // Implement this function to get the current board ID.
    const cardId = document.getElementById('deleteCardId').value;

    if (!cardId) {
        alert('Please enter a valid card ID.');
        return;
    }

    if (confirm('Are you sure you want to delete this card?')) {
        await deleteCardFromBoard(boardId, cardId);
        showCards(boardId);
    }
}

// Call loadBoards() on page load
loadBoards();