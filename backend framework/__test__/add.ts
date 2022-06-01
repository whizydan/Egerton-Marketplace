const addTwo = (x: number, y: number) => x + y
describe('Add two', () => {
	test('add two', () => {
		const three = addTwo(1, 2)
		expect(three).toEqual(3)
	})
})
