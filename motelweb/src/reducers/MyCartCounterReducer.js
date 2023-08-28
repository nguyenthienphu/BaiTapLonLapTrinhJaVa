const MyCartCounterReducer = (currenState, action) => {
    switch (action.type) {
        case "inc":
            return currenState + action.payload;
        case "dec":
            return currenState - action.payload;
        default:
            return currenState;
    }
}
export default MyCartCounterReducer;